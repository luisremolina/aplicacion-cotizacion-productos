$( document ).ready(function() {

    let item = localStorage.getItem("sesion");
    if(item === "activa"){
        document.querySelector("#loginid").style.display = 'none';
        document.querySelector("#registrarseid").style.display = 'none';
        document.querySelector("#cerrarsesionid").style.display = 'block';
    }else {
        document.querySelector("#loginid").style.display = 'block';
        document.querySelector("#registrarseid").style.display = 'block';
        document.querySelector("#cerrarsesionid").style.display = 'none';
    }

});

function cerrarsesion(){
    localStorage.removeItem("sesion");
    location.reload();
}

