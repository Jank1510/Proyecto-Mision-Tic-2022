/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.controller;

import com.aalejoz.chiquitinesmcv.bd.factory.FabricaConexion;
import com.aalejoz.chiquitinesmvc.model.DAO.ContactoDAO;
import com.aalejoz.chiquitinesmvc.model.DAO.UsuarioDAO;
import com.aalejoz.chiquitinesmvc.model.entities.Contacto;
import com.aalejoz.chiquitinesmvc.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alvar
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/users_login"})
public class UsuarioController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        FabricaConexion fabrica = new FabricaConexion();
        ContactoDAO contactoDAO = new ContactoDAO(fabrica.getConexion("MYSQL"));
        UsuarioDAO usuarioDAO = new UsuarioDAO(fabrica.getConexion("MYSQL"));

        if (request.getParameter("cerrar") != null) {
            sesion.invalidate();
        }

        if (request.getParameter("ingresar") != null) {
            String username = request.getParameter("usuario");
            String password = request.getParameter("password");

            Usuario u = usuarioDAO.login(username, password);

            if (u.getId() != 0) {
                sesion.setAttribute("AUTORIZADO", "SI");
                sesion.setMaxInactiveInterval(120);
                u.setPassword("");
                sesion.setAttribute("usuario", u);

                ArrayList<Contacto> contactos = contactoDAO.listadoContactenos();

                request.setAttribute("contactos", contactos);

                request.getRequestDispatcher("seccion_admin.jsp").forward(request, response);

                return;

            }

        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

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
