package com.misiontic2022.apichiquitines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Sugerencia;
import com.misiontic2022.apichiquitines.repository.SugerenciaRepository;

@Service
public class SugerenciaService {

	@Autowired
	SugerenciaRepository sugerenciaRepository;

	public List<Sugerencia> getSugerencias() {

		return sugerenciaRepository.findAll();
	}

	public Sugerencia getSugerencia(Integer id) {
		Optional<Sugerencia> sugerencia = this.sugerenciaRepository.findById(id);
		if (sugerencia.isPresent()) {
			return sugerencia.get();
		} else {
			return new Sugerencia();
		}
	}

	public Sugerencia addSugerencia(Sugerencia sugerencia) {
		return this.sugerenciaRepository.save(sugerencia);
	}

	public void deleteSugerencia(Integer id) {
		this.sugerenciaRepository.deleteById(id);
	}

}
