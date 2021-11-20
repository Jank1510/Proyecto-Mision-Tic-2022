package com.misiontic2022.apichiquitines.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noticias")
public class Noticia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	private Byte[] imagen;
	private String descripcion;
	public Noticia(Date fecha, Byte[] imagen, String descripcion) {
		super();
		this.fecha = fecha;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}
	public Noticia() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Byte[] getImagen() {
		return imagen;
	}
	public void setImagen(Byte[] imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
