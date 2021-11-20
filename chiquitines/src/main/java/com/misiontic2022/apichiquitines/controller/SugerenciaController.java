package com.misiontic2022.apichiquitines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.apichiquitines.model.Sugerencia;
import com.misiontic2022.apichiquitines.service.SugerenciaService;

@RestController
@RequestMapping("/sugerencias")
public class SugerenciaController {
	@Autowired
	private SugerenciaService sugerenciaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Sugerencia> getSugerencia() {
		return this.sugerenciaService.getSugerencias();
		// return productoRespository.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Sugerencia getSugerencia(@PathVariable Integer id) {

		Sugerencia sugerencia = this.sugerenciaService.getSugerencia(id);

		return sugerencia;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Sugerencia addSugerencia(@RequestBody Sugerencia sugerencia) {
		return this.sugerenciaService.addSugerencia(sugerencia);
	}



}
