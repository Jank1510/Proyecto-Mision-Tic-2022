<%-- 
    Document   : menu
    Created on : 8/12/2021, 1:52:35 a. m.
    Author     : alvar
--%>

<%@page import="com.aalejoz.chiquitinesmvc.model.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="menu">
    <header> 
        <li id="logo"><img src="./img/logo.png" width="150">

            <ul id="menuDesktop">


                <%
                    HttpSession sesion = request.getSession();
                    if (sesion.getAttribute("AUTORIZADO") == null) {
                %>  
                <li id="itemDesktop">
                    <a  href="index.jsp">Inicio</a>
                </li>
                <% }%>



                <%
                    if (sesion.getAttribute("AUTORIZADO") == null) {
                %>  
                <li id="itemDesktop">
                    <a  href="contactenos">Contáctenos</a>
                </li>
                <% }%>



                <%
                    if (sesion.getAttribute("AUTORIZADO") == null) {
                %>  
                <li id="itemDesktop">
                    <a  href="users_login">Iniciar Sesion </a>
                </li>
                <% }%>





                <%
                    if (sesion.getAttribute("AUTORIZADO") != null) {
                        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                %>  
                <li id="itemDesktop">
                    <a  href="users_login?cerrar">Cerrar Sesion (<%= usuario.getNickName()%>)</a>
                </li>
                <% }%>
            </ul>



        </li>




    </header>
</div>
