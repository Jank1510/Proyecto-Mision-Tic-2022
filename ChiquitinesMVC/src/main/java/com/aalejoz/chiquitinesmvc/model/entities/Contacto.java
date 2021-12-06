/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmvc.model.entities;

/**
 *
 * @author alvar
 */
public class Contacto {
    
    private int id;
    private String nombresApellidos;
    private String correo;
    private String mensaje;

    public Contacto() {
    }

    public Contacto(int id, String nombresApellidos, String correo, String mensaje) {
        this.id = id;
        this.nombresApellidos = nombresApellidos;
        this.correo = correo;
        this.mensaje = mensaje;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
