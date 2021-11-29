package com.misiontic2022.apichiquitines.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class NoticiaUtil {
	private String tituloNoticia;
	private String descripcion;
	public NoticiaUtil(String titulonoticia, String descripcion) {
		super();
		this.tituloNoticia = titulonoticia;
		this.descripcion = descripcion;
	}
	public NoticiaUtil() {
		super();
	}
	public String getTituloNoticia() {
		return tituloNoticia;
	}
	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
