package com.misiontic2022.apichiquitines.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;

	public List<Curso> getCursos() {

		return cursoRepository.findAll();
	}

	public Curso addCurso(Curso curso) {
		return this.cursoRepository.save(curso);
	}

	public void deleteCurso(Integer id) {
		this.cursoRepository.deleteById(id);
	}
}
