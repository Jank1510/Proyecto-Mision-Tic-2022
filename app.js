//funcion para obtener los datos del apartado del contactenos
var getDatos = function () {
    var datos = document.getElementById("nombreapellido").value;
    var email = document.getElementById("email").value;
    var mensaje = document.getElementById("mensaje").value;
    var telefono = document.getElementById("telefono").value;
    var condiciones = (document.getElementById("condiciones")).checked;

    if (datos == "") {
        swal("Oops!", "La casilla de nombres y apellidos no puede ir vacia", "error");
        document.getElementById("nombreapellido").focus();
    } else {
        if (email == "") {

            swal("Oops!", "La casilla de E-mail no puede ir vacia", "error");
            document.getElementById("email").focus();
        } else {
            if (mensaje == "") {
                swal("Oops!", "La casilla de mensajes no puede ir vacia", "error");
                document.getElementById("mensaje").focus();
            } else {
                if (condiciones == false) {
                    swal("Oops!", "Debes aceptar nuestra politica de privacidad", "error");                  
                }else{
                    document.getElementById("nombreapellido").value="";
                    document.getElementById("email").value="";
                    document.getElementById("mensaje").value="";
                    document.getElementById("telefono").value="";
                    (document.getElementById("condiciones")).click();
                    swal("Enviado con exito!","", "success");
                    
                     console.log(datos + " " + email + " " + mensaje + " " + telefono);
                }
            }

        }
    }
}