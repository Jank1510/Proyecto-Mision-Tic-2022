/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aalejoz.chiquitinesmcv.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alvar
 */
@WebFilter("/*")
public class AutorizacionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sesion = ((HttpServletRequest) request).getSession();
        HttpServletRequest peticion = ((HttpServletRequest) request);
        String url = peticion.getRequestURI();
        
        

      

        if (url.equals("/chiquitines/users_login") || url.equals("/chiquitines/contactenos") || url.equals("/chiquitines/index.jsp") || url.contains("/css")) {
            chain.doFilter(request, response);
        } else {
            if (sesion.getAttribute("AUTORIZADO") == null) {
                ((HttpServletResponse) response).sendRedirect("index.jsp");
                return;
            }
            ((HttpServletResponse) response).sendRedirect("index.jsp");
        }

    }

    @Override
    public void destroy() {
    }

}
