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
	
	@JoinColumn(name = "nombre_recurso")
	private String nombreRecurso;
	
	@JoinColumn(name = "nombre_archivo")
	private String nombreArchivo;
	
	@Column(name = "tipo_archivo")
	private String tipoArchivo;
	
	private Long tamaño;
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

	public Recurso(String nombreRecurso, String nombreArchivo, String tipoArchivo, Long tamaño, String ruta,
			Materia materia, Curso curso, Usuario usuario) {
		super();
		this.nombreRecurso = nombreRecurso;
		this.nombreArchivo = nombreArchivo;
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

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public Long getTamaño() {
		return tamaño;
	}

	public void setTamaño(Long tamaño) {
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
