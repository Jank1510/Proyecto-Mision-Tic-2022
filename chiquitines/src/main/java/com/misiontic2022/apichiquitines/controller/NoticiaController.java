package com.misiontic2022.apichiquitines.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.apichiquitines.service.NoticiaService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecursoController.class);
	
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private RecursoService recursoService;
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private UsuarioService usuarioService;

	// Devuelve las imagenes al navegador
	private String FILE_PATH_ROOT = "C:/ChiquitinesResources/Noticias/";

	@GetMapping("/{filename}")
	public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
		byte[] image = new byte[0];
		try {
			image = FileUtils.readFileToByteArray(new File(FILE_PATH_ROOT + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

	

	

	@RequestMapping(value = "/subir_recurso", method = RequestMethod.POST)
	public Recurso subirRecurso(@RequestParam("archivo") MultipartFile file,
			@RequestParam("recurso") String recursoUtil) {
		RecursoUtil ru = new Gson().fromJson(recursoUtil, RecursoUtil.class);
		String fileName = recursoService.obtenerNombre(file);
		Materia materia = materiaService.getMateria(ru.getMateria().getId());
		Usuario usuario = usuarioService.getUsuario(ru.getUsuario().getId());
		Curso curso = cursoService.getCurso(ru.getUsuario().getId());
		usuario.setContraseña("");

		List<Recurso> recursos = recursoService.getRecursos();
		String numeroRecurso = String.valueOf(recursos.get(recursos.size() - 1).getId());

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("recursos/descargar_recurso/").path(numeroRecurso + fileName).toUriString();
		Recurso recurso = new Recurso(numeroRecurso + fileName, file.getContentType(), file.getSize(), fileDownloadUri,
				materia, curso, usuario);
		recursoService.guardarRecurso(file, recurso, numeroRecurso + fileName);
		return recurso;
	}

	@RequestMapping(value = "/descargar_recurso/{fileName:.+}", method = RequestMethod.GET)
	public ResponseEntity<Resource> descargarRecurso(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = recursoService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Recurso> getRecursos() {
		return recursoService.getRecursos();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRecurso(@PathVariable("id") Integer id) throws IOException {

		Files.deleteIfExists(
				Paths.get("C:/ChiquitinesResources/ArchivosProfesores/" + recursoService.getRecurso(id).getNombre()));
		this.recursoService.deleteRecurso(id);
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Recurso getRecurso(@PathVariable Integer id) {
		Recurso recurso = this.recursoService.getRecurso(id);
		return recurso;
	}
}
