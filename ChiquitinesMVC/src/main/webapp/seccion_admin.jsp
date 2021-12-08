<%-- 
    Document   : seccion_admin
    Created on : 8/12/2021, 9:49:50 a. m.
    Author     : alvar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.aalejoz.chiquitinesmvc.model.entities.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Los Chiquitines Principal</title>
    <link rel="shortcut icon" href="img/cap.png" width="100">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css Mostly Fluid/phone.css">
    <link rel="stylesheet" href="./css Mostly Fluid/desktop.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body> 
    <%@include file="WEB-INF/menu.jsp" %>



    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>N</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Mensaje</th>
            </tr>
        </thead>
        <tbody>

            <%
                ArrayList<Contacto> contactos = (ArrayList<Contacto>) request.getAttribute("contactos");
                int i = 0;
                for (Contacto c : contactos) {
                    i++;
            %>
            <tr>
                <td><%=i%></td>
                <td><%=c.getNombresApellidos()%></td>
                <td><%=c.getCorreo()%></td>
                <td><textarea readonly><%=c.getMensaje()%></textarea> </td>        
            </tr>
            <%
                }
            %>




        </tbody>
    </table>


    <%@include file="WEB-INF/footer.jsp" %>
