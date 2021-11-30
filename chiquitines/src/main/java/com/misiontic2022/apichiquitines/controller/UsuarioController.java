package com.misiontic2022.apichiquitines.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.filter.RequestFilter;
import com.misiontic2022.apichiquitines.model.Usuario;
import com.misiontic2022.apichiquitines.service.UsuarioService;
import com.misiontic2022.apichiquitines.util.UsuarioUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public UsuarioUtil login(@RequestBody Usuario usuario) {

		Usuario u = this.usuarioService.login(usuario);
		UsuarioUtil usuarioUtil = new UsuarioUtil();
		usuarioUtil.setId(u.getId());
		usuarioUtil.setNickName(u.getNickName());
		usuarioUtil.setContraseña("");
		usuarioUtil.setNombres(u.getNombres());
		usuarioUtil.setApellidos(u.getApellidos());

		usuarioUtil.setRol(u.getRol());
		String token = "";
		if (u.getId() != 0) {
			long tiempo = System.currentTimeMillis();
			token = Jwts.builder().signWith(SignatureAlgorithm.HS256, RequestFilter.KEY)
					.setSubject(usuarioUtil.getNickName()).setIssuedAt(new Date(tiempo))
					.setExpiration(new Date(tiempo + 900000)).claim("nickName", usuarioUtil.getNickName())
					.claim("rol", usuarioUtil.getRol()).compact();

		}
		usuarioUtil.setToken(token);

		return usuarioUtil;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/agregar")
	public ResponseEntity<String> agregarUsuario(@RequestBody Usuario usuario) {
		if (usuario.getRol().getId()==1) {
			return ResponseEntity.ok(new Gson().toJson("No puede agregar otro usuario administrador"));
		}
		else {		
			usuarioService.agregarUsuario(usuario);		
			return ResponseEntity.ok(new Gson().toJson(usuario));	
		}		
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/borrar")
	public ResponseEntity<String> borrarUsuario(@RequestBody Usuario usuario) {
		if (usuario.getRol().getId()==1) {
			return ResponseEntity.ok(new Gson().toJson("No puede borrar el usuario administrador"));
		}
		else {		
			usuarioService.borrarUsuario(usuario);	
			return ResponseEntity.ok(new Gson().toJson("Usuario eliminado"));	
		}		
		
	}
}
