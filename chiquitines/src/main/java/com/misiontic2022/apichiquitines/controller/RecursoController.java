package com.misiontic2022.apichiquitines.controller;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.model.Materia;
import com.misiontic2022.apichiquitines.model.Recurso;
import com.misiontic2022.apichiquitines.model.Usuario;
import com.misiontic2022.apichiquitines.service.CursoService;
import com.misiontic2022.apichiquitines.service.MateriaService;
import com.misiontic2022.apichiquitines.service.RecursoService;
import com.misiontic2022.apichiquitines.service.UsuarioService;
import com.misiontic2022.apichiquitines.util.RecursoUtil;
import com.misiontic2022.apichiquitines.util.RecursosFileStorageProperties;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

	private static final Logger logger = LoggerFactory.getLogger(RecursoController.class);

	@Autowired
	private RecursoService recursoService;
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RecursosFileStorageProperties recursoStorageProperties;

	@RequestMapping(value = "/subir_recurso", method = RequestMethod.POST)
	public Recurso subirRecurso(@RequestParam("archivo") MultipartFile file,
			@RequestParam("recurso") String recursoUtil) {
		RecursoUtil ru = new Gson().fromJson(recursoUtil, RecursoUtil.class);
		String nombreRecurso = ru.getNombreRecurso();
		String fileName = recursoService.obtenerNombre(file);
		Materia materia = materiaService.getMateria(ru.getMateria().getId());
		Usuario usuario = usuarioService.getUsuario(ru.getUsuario().getId());
		Curso curso = cursoService.getCurso(ru.getCurso().getId());

		List<Recurso> recursos = recursoService.getRecursos();
		String numeroRecurso;
		if (recursos.size() == 0) {
			numeroRecurso = "1";
		} else {
			numeroRecurso = String.valueOf(recursos.get(recursos.size() - 1).getId() + 1);
		}

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("recursos/descargar_recurso/").path(numeroRecurso + fileName).toUriString();
		Recurso recurso = new Recurso(nombreRecurso, numeroRecurso + fileName, file.getContentType(), file.getSize(),
				fileDownloadUri, materia, curso, usuario);
		recursoService.guardarRecurso(file, recurso, numeroRecurso + fileName);
		usuario.setContraseña("");
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

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Recurso> getRecursos() {
		List<Recurso> recursos = recursoService.getRecursos();
		for (Recurso r : recursos) {
			r.getUsuario().setContraseña("");
		}
		return recursos;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteRecurso(@PathVariable("id") Integer id) throws IOException {

		Files.deleteIfExists(Paths
				.get(recursoStorageProperties.getUploadDir() + "\\" + recursoService.getRecurso(id).getNombreArchivo())
				.toAbsolutePath().normalize());

		try {
			this.recursoService.deleteRecurso(id);
			return ResponseEntity.ok(new Gson().toJson("Recurso eliminado"));
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.ok(new Gson().toJson("El recurso que referencia no existe: " + e));
		}

	}

	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Recurso getRecurso(@PathVariable Integer id) {
		Recurso recurso = this.recursoService.getRecurso(id);
		recurso.getUsuario().setContraseña("");
		return recurso;
	}

}
