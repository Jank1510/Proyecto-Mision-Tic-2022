package com.misiontic2022.apichiquitines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic2022.apichiquitines.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario getByNickNameAndContraseña(String nickName, String contraseña);

}
