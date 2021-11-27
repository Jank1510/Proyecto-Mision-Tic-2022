package com.misiontic2022.apichiquitines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Materia;
import com.misiontic2022.apichiquitines.repository.MateriaRepository;

@Service
public class MateriaService {
	@Autowired
	MateriaRepository materiaRepository;

	public List<Materia> getMaterias() {

		return materiaRepository.findAll();
	}

	public Materia addMateria(Materia materia) {
		return this.materiaRepository.save(materia);
	}

	public void deleteMateria(Integer id) {
		this.materiaRepository.deleteById(id);
	}
}
