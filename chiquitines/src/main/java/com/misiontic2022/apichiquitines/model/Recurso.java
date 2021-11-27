package com.misiontic2022.apichiquitines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recursos")
public class Recurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@Column(name = "tipo_archivo")
	private String tipoArchivo;
	
	private String tamaño;
	private String ruta;
	
	@ManyToOne
	@JoinColumn(name = "materias_id")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "cursos_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id")
	private Usuario usuario;

	

	public Recurso(String nombre, String tipoArchivo, String tamaño, String ruta, Materia materia, Curso curso,
			Usuario usuario) {
		super();
		this.nombre = nombre;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.ruta = ruta;
		this.materia = materia;
		this.curso = curso;
		this.usuario = usuario;
	}
	
	

	public Recurso() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTipoArchivo() {
		return tipoArchivo;
	}



	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}



	public String getTamaño() {
		return tamaño;
	}



	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}



	public Materia getMateria() {
		return materia;
	}



	public void setMateria(Materia materia) {
		this.materia = materia;
	}



	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	
	
	
}
