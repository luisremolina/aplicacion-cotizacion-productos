function login(){
    let data = {
        "email": $("#correo").val(),
        "password": $("#password").val()
    }
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/v1/usuarios/login",
        contentType: "application/json",
        data: JSON.stringify(data),
    }).done(function(data) {
        if (data == ''){
            alert('Credenciales incorrectas')
            return
        }
        localStorage.setItem("sesion", "activa");
        document.getElementById("homelink").click();
    }).fail(function(e) {
        alert("Algo salio mal");
    });
}

function registrarUsuario(){
    let nombre = $("#nombres").val();
    let apellido = $("#apellidos").val();
    let correo = $("#correo").val();
    let clave = $("#password").val();

    let data = {
        "name": nombre + ' '+apellido,
        "email": correo,
        "password": clave,
        "username": nombre+apellido,
        "rol": "user1"
    }

    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/v1/usuarios",
        contentType: "application/json",
        data: JSON.stringify(data),
    }).done(function(data) {
    alert("Se ha registrado con exito el usuario");
         $("#nombres").val("");
         $("#apellidos").val("");
         $("#correo").val("");
         $("#password").val("");

    }).fail(function(e) {
        console.log(e);
        alert("Algo salió mal");
    });

}