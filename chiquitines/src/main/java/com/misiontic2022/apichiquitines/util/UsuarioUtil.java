package com.misiontic2022.apichiquitines.util;

import com.misiontic2022.apichiquitines.model.Rol;

public class UsuarioUtil {

	private Integer id;	
	private String nickName;
	private String contraseña;
	private String nombres;
	private String apellidos;
	private Rol rol;
	private String token;
	public UsuarioUtil(Integer id, String nickName, String contraseña, String nombres, String apellidos, Rol rol,
			String token) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.contraseña = contraseña;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
		this.token = token;
	}
	public UsuarioUtil() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
