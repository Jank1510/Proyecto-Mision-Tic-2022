/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmvc.model.DAO;

import com.aalejoz.chiquitinesmcv.bd.interfaces.IConexion;
import com.aalejoz.chiquitinesmvc.model.entities.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alvar
 */
public class UsuarioDAO {

    private IConexion conexion;

    public UsuarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public Usuario login(String nickName, String password) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuarios WHERE nick_name = ? AND contraseña = ?";
            PreparedStatement pst = this.conexion.conectar().prepareStatement(sql);
            pst.setString(1, nickName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNickName(rs.getString("nick_name"));
                usuario.setPassword(rs.getString("contraseña"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return usuario;
    }

}
