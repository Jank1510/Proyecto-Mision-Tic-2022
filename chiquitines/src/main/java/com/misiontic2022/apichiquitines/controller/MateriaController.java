package com.misiontic2022.apichiquitines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.model.Materia;
import com.misiontic2022.apichiquitines.model.Recurso;
import com.misiontic2022.apichiquitines.model.Usuario;
import com.misiontic2022.apichiquitines.service.MateriaService;
import com.misiontic2022.apichiquitines.util.RecursoUtil;

@RestController
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Materia> getMaterias() {
		return this.materiaService.getMaterias();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public Materia addMateria(@RequestBody Materia materia) {
		return this.materiaService.addMateria(materia);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMateria(@PathVariable("id") Integer id) {
		this.materiaService.deleteMateria(id);
		return ResponseEntity.ok(null);
	}
	
	
}
