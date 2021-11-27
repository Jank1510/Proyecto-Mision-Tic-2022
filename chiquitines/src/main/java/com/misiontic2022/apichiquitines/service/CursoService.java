package com.misiontic2022.apichiquitines.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.misiontic2022.apichiquitines.model.Contacto;
import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.repository.ContactoRepository;
import com.misiontic2022.apichiquitines.repository.CursoRepository;

public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	

	public Curso addCurso(Curso curso) {
		return this.cursoRepository.save(curso);
	}

	public void deleteCurso(Integer id) {
		this.cursoRepository.deleteById(id);
	}
}
