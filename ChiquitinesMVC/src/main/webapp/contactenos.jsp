<%-- 
    Document   : contactenos.jsp
    Created on : 8/12/2021, 2:10:49 a. m.
    Author     : alvar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contactenos</title>
    <link rel="shortcut icon" href="img/cap.png" width="100">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css Mostly Fluid/phone.css">
    <link rel="stylesheet" href="./css Mostly Fluid/desktop.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>

<body>

    <%@include file="WEB-INF/menu.jsp" %>

    <main id="maincontactenos">
        <form class="flex">
            <legend>
                <h1 style="text-align: center">Contactenos</h1>
            </legend>
            <br>
            <input id="nombreapellido" type="text" name="nombres" required="true"  class="textos"
                   placeholder="  Nombres y Apellidos *">
            <br>
            <br>
            <input id="email" type="email" name="email"  class="textos" required="true" placeholder="  Email *">

            <br>
            <br>
            <textarea id="mensaje" name="mensaje"  class="textos" required="true" placeholder=" Mensaje *"></textarea>
            <br>
            <br>
            <div id="parrafocontactenos">
                <p>
                    Instituto los chiquitines te informa que los
                    datos de caracter personal que proporciones rellenando este
                    formulario seran tratados por nuestra Institucion. La finalidad de la recogida
                    y tratamiento de tus datos personales es dar respuestas a solicitudes de contacto
                    y envio de contenidos. la legitimacion se realiza a traves de tu consentimiento.
                    (Campos obligatorios *)
                </p>
            </div>

            <br>
            <input type="checkbox" required="true" name="Politica " id="condiciones"> Aceptar politica de privacidad
            <br><br><br>

            <input onclick="getDatos()" type="submit" name="subir" value="Enviar"/>
        </form>

    </main>


    <%@include file="WEB-INF/footer.jsp" %>
