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
        <script src="./js/login.js"></script>
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
                        <form>
                            <input type="text" id="login" class="fadeIn second" name="login" placeholder="Usuario">
                            <input type="text" id="password" class="fadeIn third" name="login" placeholder="Contraseña">
                            <input type="button" class="fadeIn fourth" onclick="validarLogin()" value="Entrar">
                        </form>

                    </div>
                </div>

            </div>
        </div>
        <%@include file="WEB-INF/footer.jsp" %>