/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.controller;

import com.aalejoz.chiquitinesmcv.bd.factory.FabricaConexion;
import com.aalejoz.chiquitinesmvc.model.DAO.ContactoDAO;
import com.aalejoz.chiquitinesmvc.model.entities.Contacto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alvar
 */
@WebServlet(name = "ContactoController", urlPatterns = {"/contactenos"})
public class ContactoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FabricaConexion fabrica = new FabricaConexion();
        ContactoDAO contactoDAO = new ContactoDAO(fabrica.getConexion("MYSQL"));

        boolean subir = (request.getParameter("subir") != null) ? true : false;
        

        if (subir) {
            Contacto contacto = new Contacto();
            contacto.setNombresApellidos(String.valueOf(request.getParameter("nombres")));
            contacto.setCorreo(String.valueOf(request.getParameter("email")));
            contacto.setMensaje(String.valueOf(request.getParameter("mensaje")));
            contactoDAO.add(contacto);
            response.sendRedirect("contactenos");
        } else {

            request.getRequestDispatcher("contactenos.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
