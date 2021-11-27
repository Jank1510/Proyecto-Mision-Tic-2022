package com.misiontic2022.apichiquitines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.apichiquitines.model.Usuario;
import com.misiontic2022.apichiquitines.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario agregarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}

	public Usuario login(Usuario usuario) {
		Usuario u = this.usuarioRepository.getByNickNameAndContraseña(usuario.getNickName(), usuario.getContraseña());
		if (u != null) {
			usuario.setId(u.getId());
			usuario.setRol(u.getRol());
			usuario.setNombres(u.getNombres());
			usuario.setApellidos(u.getApellidos());
		}

		return usuario;
	}

}
