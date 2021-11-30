package com.misiontic2022.apichiquitines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.apichiquitines.model.Contacto;
import com.misiontic2022.apichiquitines.service.ContactoService;

@RestController
@RequestMapping("/sugerencias")
public class ContactoController {
	
	@Autowired
	private ContactoService contactoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Contacto> getContactos() {
		return this.contactoService.getContactos();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Contacto getContacto(@PathVariable Integer id) {

		Contacto contacto = this.contactoService.getContacto(id);

		return contacto;
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Contacto addContacto(@RequestBody Contacto contacto) {
		return this.contactoService.addContacto(contacto);
	}



}
