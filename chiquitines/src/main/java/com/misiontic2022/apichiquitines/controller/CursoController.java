package com.misiontic2022.apichiquitines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Curso> getCursos() {
		return this.cursoService.getCursos();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public Curso addCurso(@RequestBody Curso curso) {
		return this.cursoService.addCurso(curso);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCurso(@PathVariable("id") Integer id) {
		this.cursoService.deleteCurso(id);
		return ResponseEntity.ok(new Gson().toJson("Curso eliminado"));
	}
	
	
}
