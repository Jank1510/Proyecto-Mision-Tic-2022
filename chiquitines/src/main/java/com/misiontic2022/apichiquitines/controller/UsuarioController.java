package com.misiontic2022.apichiquitines.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.filter.RequestFilter;
import com.misiontic2022.apichiquitines.model.Usuario;
import com.misiontic2022.apichiquitines.service.UsuarioService;
import com.misiontic2022.apichiquitines.util.UsuarioUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

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
					.setExpiration(new Date(tiempo + 900000)).claim("id", usuarioUtil.getId())
					.claim("nickName", usuarioUtil.getNickName()).claim("rol", usuarioUtil.getRol()).compact();

		}
		usuarioUtil.setToken(token);

		return usuarioUtil;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/agregar")
	public ResponseEntity<String> agregarUsuario(@RequestBody Usuario usuario) {
		if (usuario.getRol().getId() == 1) {
			return ResponseEntity.ok(new Gson().toJson("No puede agregar otro usuario administrador"));
		} else {
			try {
				usuarioService.agregarUsuario(usuario);
				usuario.setContraseña("");
				return ResponseEntity.ok(new Gson().toJson(usuario));
			} catch (DataIntegrityViolationException e) {
				return ResponseEntity.ok("ERROR: POSIBLEMENTE ESE NICKNAME YA EXISTE " + e);
			}
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/borrar/{id}")
	public ResponseEntity<String> borrarUsuario(@PathVariable("id") Integer id) {
		if (id == 5) {
			return ResponseEntity.ok(new Gson().toJson("No puede borrar el usuario administrador"));
		} else {
			try {
				usuarioService.borrarUsuario(id);
				return ResponseEntity.ok(new Gson().toJson("Usuario eliminado"));
			} catch (DataIntegrityViolationException d) {
				return ResponseEntity
						.ok(new Gson().toJson("El usuario no se puede borrar, esta asociado a algun recurso: " + d));
			} catch (EmptyResultDataAccessException e) {
				return ResponseEntity.ok(new Gson().toJson("El usuario que referencia no existe: " + e));
			}

		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		for (Usuario u : usuarios) {
			u.setContraseña("");
		}
		return usuarios;
	}

	@RequestMapping(value = "/tokenIsValid", method = RequestMethod.POST)
	public ResponseEntity<Boolean> isValid(@RequestBody String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(RequestFilter.KEY).parseClaimsJws(token);
			return ResponseEntity.ok(true);
		} catch (MalformedJwtException e) {
			return ResponseEntity.ok(false);
		} catch (SignatureException e) {
			return ResponseEntity.ok(false);
		} catch (ExpiredJwtException e) {
			return ResponseEntity.ok(false);
		} catch (Exception e) {
			return ResponseEntity.ok(false);

		}

	}

}
