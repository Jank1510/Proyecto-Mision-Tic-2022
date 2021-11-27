package com.misiontic2022.apichiquitines.util;

import com.misiontic2022.apichiquitines.model.Rol;

public class UsuarioUtil {

	private Integer id;	
	private String nickName;
	private String contraseña;
	private Rol rol;
	private String token;
	
	public UsuarioUtil() {
		super();
	}

	
	public UsuarioUtil(Integer id, String usuario, String password, Rol rol, String token) {
		super();
		this.id = id;
		this.nickName = usuario;
		this.contraseña = password;
		this.rol = rol;
		this.token = token;
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
