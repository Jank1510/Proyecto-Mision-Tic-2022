package com.misiontic2022.apichiquitines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.apichiquitines.model.Rol;
import com.misiontic2022.apichiquitines.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private RolService rolService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Rol> getRoles() {
		return this.rolService.getRoles();
	}
}
