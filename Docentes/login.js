var validarLogin = function(){
    var usuario = document.getElementById("login").value;
    var contraseña = document.getElementById("password").value;
    console.log(usuario+" "+contraseña);

    if (usuario == ""){
        swal("Oops!", "La casilla de usuario no puede ir vacia", "error");
        document.getElementById("login").focus();
    }else {
        if (contraseña == ""){
            swal("Oops!", "La casilla de contraseña no puede ir vacia", "error");
        document.getElementById("password").focus();
        }
    }
}