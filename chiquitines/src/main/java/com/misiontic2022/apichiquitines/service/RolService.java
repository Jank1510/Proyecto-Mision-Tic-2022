package com.misiontic2022.apichiquitines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Rol;
import com.misiontic2022.apichiquitines.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	RolRepository rolRepository;

	public List<Rol> getRoles() {

		return rolRepository.findAll();
	}
}
