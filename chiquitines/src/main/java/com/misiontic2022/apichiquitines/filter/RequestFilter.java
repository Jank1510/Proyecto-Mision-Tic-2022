package com.misiontic2022.apichiquitines.filter;

import java.io.IOException;
import java.security.Key;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Component
public class RequestFilter implements Filter{

	public static final Key KEY = MacProvider.generateKey();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest peticion = (HttpServletRequest) request;

		String url = peticion.getRequestURI();
		// validacion de recursos (/usuarios/login y /usuarios/registro)
		if (url.contains("/usuarios/login")||url.contains("/usuarios/agregar")) {
			chain.doFilter(request, response);
		} else {

			String token = peticion.getHeader("Authorization");
			if (token == null || token.trim().equals("")) {
				response.setContentType("application/json");
				String salida = "{\"AUTORIZACION\": \"NO_TOKEN\"}";
				response.getWriter().write(salida);
			} else {

				token = token.substring(7, token.length());
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
					String salida = "{\"AUTORIZACION\": \"ERROR\"}";
					response.getWriter().write(salida);

				}

			}

		}

	}

}
