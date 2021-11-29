package com.misiontic2022.apichiquitines.controller;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
//Completar controlador

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

	@RequestMapping(value = "/subir_recurso", method = RequestMethod.POST)
	public Recurso subirRecurso(@RequestParam("archivo") MultipartFile file, @RequestParam("recurso") String recursoUtil) {
		RecursoUtil ru = new Gson().fromJson(recursoUtil, RecursoUtil.class);
		String fileName = recursoService.obtenerNombre(file);
		Materia materia = materiaService.getMateria(ru.getMateria().getId());
		Usuario usuario = usuarioService.getUsuario(ru.getUsuario().getId());
		usuario.setContraseña("");
		Curso curso = cursoService.getCurso(ru.getUsuario().getId());
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("recursos/descargar_recurso/")
				.path(fileName).toUriString();
		Recurso recurso = new Recurso(fileName, file.getContentType(), file.getSize(), fileDownloadUri, materia, curso,
				usuario);
		recursoService.guardarRecurso(file, recurso);
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
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Recurso> getRecursos() {
		return recursoService.getRecursos();
	}

}
