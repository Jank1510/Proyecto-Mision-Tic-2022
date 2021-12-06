/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.bd.interfaces;

import java.sql.Connection;

/**
 *
 * @author alvar
 */
public interface IConexion {
    
    Connection conectar();
    void desconectar();
    
}
