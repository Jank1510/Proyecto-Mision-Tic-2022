package com.misiontic2022.apichiquitines.model;

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

	public Recurso(String ruta, Materia materia, Curso curso, Usuario usuario) {
		super();
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
