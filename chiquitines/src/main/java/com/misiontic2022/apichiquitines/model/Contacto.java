package com.misiontic2022.apichiquitines.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactenos")
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String nombresApellidos;
	private String correo;
	private String mensaje;
	public Contacto(String nombresApellidos, String correo, String mensaje) {
		super();
		this.nombresApellidos = nombresApellidos;
		this.correo = correo;
		this.mensaje = mensaje;
	}
	public Contacto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombresApellidos() {
		return nombresApellidos;
	}
	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
