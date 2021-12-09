package com.misiontic2022.apichiquitines.filter;

import java.io.IOException;
import java.security.Key;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.model.Recurso;
import com.misiontic2022.apichiquitines.service.RecursoService;
import com.misiontic2022.apichiquitines.util.RecursoUtil;
import com.misiontic2022.apichiquitines.util.UsuarioUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Component
public class RequestFilter implements Filter {

	public static final Key KEY = MacProvider.generateKey();
	@Autowired
	private RecursoService recursoService;

	public void validarToken(ServletRequest request, ServletResponse response, FilterChain chain, String token)
			throws IOException {
		if (token == null || token.trim().equals("")) {
			response.setContentType("application/json");
			String salida = "{\"AUTORIZACION\": \"NO_TOKEN\"}";
			response.getWriter().write(salida);
		} else {

			try {
				Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
				chain.doFilter(request, response);
			} catch (MalformedJwtException e) {
				response.setContentType("application/json");
				String salida = "{\"AUTORIZACION\": \"TOKEN_MALFORMADO\"}";
				response.getWriter().write(salida);
			} catch (SignatureException e) {
				response.setContentType("application/json");
				String salida = "{\"AUTORIZACION\": \"TOKEN_SIGNATURE\"}";
				response.getWriter().write(salida);
			} catch (ExpiredJwtException e) {
				response.setContentType("application/json");
				String salida = "{\"AUTORIZACION\": \"TOKEN_EXPIRED\"}";
				response.getWriter().write(salida);
			} catch (Exception e) {
				response.setContentType("application/json");
				String salida = "{\"AUTORIZACION\": \"ERROR, PUEDE QUE EL RECURSO NO EXISTA\"}";
				response.getWriter().write(salida);

			}

		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse respuesta = (HttpServletResponse) response;
		HttpServletRequest peticion = (HttpServletRequest) request;

		respuesta.addHeader("Access-Control-Allow-Origin", "*");
		respuesta.addHeader("Access-Control-Allow-Methods", "*");
		respuesta.addHeader("Access-Control-Allow-Headers", "*");

		String url = peticion.getRequestURI();
		String token;
		UsuarioUtil usuario;
		Integer idRol = 0;
		Integer resourceUserId;
		Integer currentUserId = 0;

		if (peticion.getParameter("recurso") != null) {
			String recursoParameter = peticion.getParameter("recurso");
			RecursoUtil recurso = new Gson().fromJson(recursoParameter, RecursoUtil.class);
			resourceUserId = recurso.getUsuario().getId();
		} else {
			resourceUserId = null;
		}

		if (peticion.getHeader("Authorization") == null) {
			token = null;
			usuario = null;
		} else {
			token = peticion.getHeader("Authorization");
			token = token.substring(7, token.length());
			String payload = token.split("\\.")[1];
			String userJson = new String(Base64.decodeBase64(payload), "UTF-8");
			usuario = new Gson().fromJson(userJson, UsuarioUtil.class);
		}

		if (usuario != null) {
			idRol = usuario.getRol().getId();
			currentUserId = usuario.getId();

		}
		System.out.println("---------------------");
		System.out.println(idRol);
		System.out.println("---------------------");
		System.out.println(url);
		System.out.println("---------------------");

		// validacion de usuarios
		if (url.contains("/usuarios")) {
			if (url.equals("/usuarios/login") || url.contains("/usuarios/tokenIsValid")) {
				chain.doFilter(request, response);
			} else if (url.contains("/getAll") || url.contains("/agregar") || url.contains("/borrar")) {
				if (idRol == 5) {
					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN\"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: DOCENTE NO PUEDE VER VER/AGREGAR/BORRAR USUARIOS \"}";
						response.getWriter().write(salida);

					}

				}

			}
		}

		// validacion de urls sugerencias
		else if (url.contains("/sugerencias")) {
			if (url.contains("/sugerencias/add")) {
				chain.doFilter(request, response);
			} else if (url.contains("/sugerencias/get") || url.equals("/sugerencias")) {
				if (idRol == 5) {

					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN\"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: DOCENTE NO PUEDE VER SUGERENCIAS \"}";
						response.getWriter().write(salida);

					}

				}
			}
		}

		// validacion urls de cursos
		else if (url.contains("/cursos")) {
			if (url.equals("/cursos")) {
				chain.doFilter(request, response);
			} else if (url.contains("/cursos/add") || url.contains("/cursos/delete")) {
				if (idRol == 5) {
					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN \"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: DOCENTE NO PUEDE AGREGAR/BORRAR CURSOS\"}";
						response.getWriter().write(salida);

					}
				}
			}
		}

		// validacion urls de materias
		else if (url.contains("/materias")) {
			if (url.equals("/materias")) {
				chain.doFilter(request, response);
			} else if (url.contains("/materias/add") || url.contains("/materias/delete")) {
				if (idRol == 5) {
					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN \"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: DOCENTE NO PUEDE AGREGAR/BORRAR MATERIAS \"}";
						response.getWriter().write(salida);

					}
				}
			}
		}

		// validacion urls de noticias
		else if (url.contains("/noticias")) {
			if (url.equals("/noticias/getAll") || url.contains("/noticias/getImg")
					|| url.contains("/noticias/obtener")) {
				chain.doFilter(request, response);
			} else if (url.contains("/noticias/subir_noticia") || url.contains("/noticias/delete")) {
				if (idRol == 5) {
					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN \"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: DOCENTE NO PUEDE AGREGAR/BORRAR NOTICIAS \"}";
						response.getWriter().write(salida);

					}
				}
			}
		}

		// validacion de urls de recursos
		else if (url.contains("/recursos")) {
			if (url.equals("/recursos/getAll") || url.contains("/recursos/descargar_recurso")
					|| url.contains("/recursos/obtener")) {
				chain.doFilter(request, response);
			} else if (url.contains("/recursos/subir_recurso")) {
				if (idRol == 15) {
					if (resourceUserId.equals(currentUserId)) {
						validarToken(request, response, chain, token);
					} else {
						String salida = "{\"ERROR\": \"NO PUEDE AGREGAR RECURSOS CON EL ID DE OTRO USUARIO\"}";
						response.getWriter().write(salida);
					}

				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN \"}";
						response.getWriter().write(salida);
					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: ADMIN NO PUEDE AGREGAR/BORRAR RECURSOS \"}";
						response.getWriter().write(salida);

					}
				}
			} else if (url.contains("/recursos/delete")) {
				Integer idRecurso = Integer.parseInt(url.split("/")[3]);
				Recurso recurso = recursoService.getRecurso(idRecurso);
				if (idRol == 15 && currentUserId == recurso.getUsuario().getId()) {
					validarToken(request, response, chain, token);
				} else {
					if (idRol == 0) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"NO INICIO SESION O NO ENVIO TOKEN \"}";
						response.getWriter().write(salida);
					} else if (idRol == 5) {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"ROL NO AUTORIZADO: ADMIN NO PUEDE BORRAR RECURSOS \"}";
						response.getWriter().write(salida);

					} else {
						response.setContentType("application/json");
						String salida = "{\"ERROR\": \"USUARIO NO AUTORIZADO: EL RECURSO NO LE PERTENECE \"}";
						response.getWriter().write(salida);
					}
				}
			}
		}

		// validacion url roles
		else if (url.equals("/roles")) {
			chain.doFilter(request, response);
		}
	}

}
