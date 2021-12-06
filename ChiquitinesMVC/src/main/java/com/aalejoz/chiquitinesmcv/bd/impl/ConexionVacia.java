/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.bd.impl;

import com.aalejoz.chiquitinesmcv.bd.interfaces.IConexion;
import java.sql.Connection;

/**
 *
 * @author alvar
 */
public class ConexionVacia implements IConexion {

    @Override
    public Connection conectar() {
        System.out.println("Conexion vacia");
        return null;
    }

    @Override
    public void desconectar() {
        System.out.println("Conexion vacia");
    }

   
    
}
