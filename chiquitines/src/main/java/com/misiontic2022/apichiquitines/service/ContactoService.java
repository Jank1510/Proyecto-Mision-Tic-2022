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
		Optional<Contacto> sugerencia = this.contactoRepository.findById(id);
		if (sugerencia.isPresent()) {
			return sugerencia.get();
		} else {
			return new Contacto();
		}
	}

	public Contacto addContacto(Contacto sugerencia) {
		return this.contactoRepository.save(sugerencia);
	}

	public void deleteContacto(Integer id) {
		this.contactoRepository.deleteById(id);
	}

}
