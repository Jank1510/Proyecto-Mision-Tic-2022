/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.bd.impl;

import com.aalejoz.chiquitinesmcv.bd.interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar
 */
public class ConexionMySQL implements IConexion {

    private String host;
    private String puerto;
    private String usuario;
    private String contraseña;
    private String baseDeDatos;
    private Connection conexion;
    private static ConexionMySQL conn;

    private ConexionMySQL() {
        this.host = "localhost";
        this.puerto = "3306";
        this.baseDeDatos= "chiquitines";
        this.usuario = "root";
        this.contraseña = "root";
    }
    
    
    public static IConexion getConexion(){
        if (conn == null) {
            conn = new ConexionMySQL();
        }
        return conn;
    }

    @Override
    public Connection conectar() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.puerto+"/"+this.baseDeDatos, this.usuario, this.contraseña);
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Ocurrio un error seleccinando el driver de mysql: "+e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Ocurrio un error conectandose al servidor mysql: "+e.getMessage());
        }
        
        return this.conexion;
    }

    @Override
    public void desconectar() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

}
