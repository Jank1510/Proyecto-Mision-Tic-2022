/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.bd.factory;

import com.aalejoz.chiquitinesmcv.bd.impl.ConexionMySQL;
import com.aalejoz.chiquitinesmcv.bd.impl.ConexionVacia;
import com.aalejoz.chiquitinesmcv.bd.interfaces.IConexion;

/**
 *
 * @author alvar
 */
public class FabricaConexion {

    public IConexion getConexion(String motor) {
        if (motor == null) {
            return new ConexionVacia();
        } else if (motor == "MYSQL") {
            return ConexionMySQL.getConexion();
        }
        return new ConexionVacia();
    }

}
