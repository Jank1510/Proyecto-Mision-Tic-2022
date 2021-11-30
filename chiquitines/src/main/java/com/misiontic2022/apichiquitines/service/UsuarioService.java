package com.misiontic2022.apichiquitines.service;

import java.util.List;
import java.util.Optional;

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

	public void borrarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
		;
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuario(Integer id) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

	public Usuario login(Usuario usuario) {
		Usuario u = this.usuarioRepository.getByNickNameAndContraseña(usuario.getNickName(), usuario.getContraseña());
		if (u != null) {
			usuario.setId(u.getId());
			usuario.setRol(u.getRol());
			usuario.setNombres(u.getNombres());
			usuario.setApellidos(u.getApellidos());
			usuario.setContraseña("");
		}

		return usuario;
	}

}
