<%-- 
    Document   : login
    Created on : 8/12/2021, 2:34:58 a. m.
    Author     : alvar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Docentes</title>
        <link rel="shortcut icon" href="./img/cap.png" width="100">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./css/loginStyle.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>

    <body id="">

        <%@include file="WEB-INF/menu.jsp" %>

        <div id="loginDocentes">
            <div id="loginCenter">
                <div class="wrapper fadeInDown">
                    <div id="formContent">
                        <!-- Tabs Titles -->
                        <h2 class="active"> Ingresar </h2>

                        <!-- Icon -->
                        <div class="fadeIn first">
                            <img src="./img/cap.png" id="icon" alt="User Icon" />
                        </div>

                        <!-- Login Form -->
                        <form method="POST" action="users_login">
                            <input type="text" required="true" id="login" class="fadeIn second" name="usuario" placeholder="Usuario">
                            <input type="password" style=" background-color: #f6f6f6;
                                   border: none;
                                   color: #0d0d0d;
                                   padding: 15px 32px;
                                   text-align: center;
                                   text-decoration: none;
                                   display: inline-block;
                                   font-size: 16px;
                                   margin: 5px;
                                   width: 85%;
                                   border: 2px solid #f6f6f6;
                                   -webkit-transition: all 0.5s ease-in-out;
                                   -moz-transition: all 0.5s ease-in-out;
                                   -ms-transition: all 0.5s ease-in-out;
                                   -o-transition: all 0.5s ease-in-out;
                                   transition: all 0.5s ease-in-out;
                                   -webkit-border-radius: 5px 5px 5px 5px;
                                   border-radius: 5px 5px 5px 5px"  id="password" required="true" class="password fadeIn third " name="password" placeholder="Contraseña">
                            <input type="submit" class="fadeIn fourth" name="ingresar" " value="Entrar">
                        </form>

                    </div>
                </div>

            </div>
        </div>
        <%@include file="WEB-INF/footer.jsp" %>