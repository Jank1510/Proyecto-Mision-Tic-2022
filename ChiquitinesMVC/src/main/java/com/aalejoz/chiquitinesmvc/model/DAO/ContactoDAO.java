/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmvc.model.DAO;

import com.aalejoz.chiquitinesmcv.bd.interfaces.IConexion;
import com.aalejoz.chiquitinesmvc.model.entities.Contacto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class ContactoDAO {
    private IConexion conexion;

    public ContactoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    
    
    public ArrayList<Contacto> listadoContactenos() {
        ArrayList<Contacto> contactenos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM contactenos";
            PreparedStatement pst = this.conexion.conectar().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Contacto c = new Contacto(rs.getInt("id"), rs.getString("nombres_apellidos"), rs.getString("correo"), rs.getString("mensaje"));
                contactenos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return contactenos;
    }
    
    public Contacto add(Contacto contacto) {
        try {
            String sql = "INSERT INTO contactenos VALUES (?,?,?,?)";
            PreparedStatement pst = this.conexion.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, contacto.getNombresApellidos());
            pst.setString(3, contacto.getCorreo());
            pst.setString(4, contacto.getMensaje());
            
            int filas = pst.executeUpdate();
            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    contacto.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return contacto;
    }
    
    
}
