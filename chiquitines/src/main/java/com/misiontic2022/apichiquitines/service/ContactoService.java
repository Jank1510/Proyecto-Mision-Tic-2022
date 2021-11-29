package com.misiontic2022.apichiquitines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Contacto;
import com.misiontic2022.apichiquitines.repository.ContactoRepository;

@Service
public class ContactoService {

	@Autowired
	ContactoRepository contactoRepository;

	public List<Contacto> getContactos() {

		return contactoRepository.findAll();
	}

	public Contacto getContacto(Integer id) {
		Optional<Contacto> contacto = this.contactoRepository.findById(id);
		if (contacto.isPresent()) {
			return contacto.get();
		} else {
			return null;
		}
	}

	public Contacto addContacto(Contacto contacto) {
		return this.contactoRepository.save(contacto);
	}

	public void deleteContacto(Integer id) {
		this.contactoRepository.deleteById(id);
	}

}
