
class Menu extends HTMLElement{
    constructor() {
        super();
        this.innerHTML = `
        <!--NAVBAR-->
            <nav class="navbar navbar-expand-lg bg-light">
              <div class="container-fluid">
                <div>
                    <img width="35px" src="img/logo.png" />
                     <a class="navbar-brand" href="#">Tienda Cotizacion</a>
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item" id="homeid">
                      <a class="nav-link active" id="homelink" aria-current="page" href="index.html">Home</a>
                    </li>
                    <li class="nav-item" id="carritoid">
                      <a class="nav-link active" aria-current="page" href="carrito.html">Productos</a>
                    </li>
                    <li class="nav-item" id="registrarseid">
                      <a class="nav-link active" aria-current="page" href="formulario-registro.html">Registrarse</a>
                    </li>
                    <li class="nav-item" id="loginid">
                      <a class="nav-link active" aria-current="page" href="formulario-login.html">Iniciar Sesión</a>
                    </li>
                    <li class="nav-item" id="cerrarsesionid">
                      <a class="nav-link active" aria-current="page" onclick="cerrarsesion()" href="#">Cerrar sesion</a>
                    </li>
                  </ul>
                  <div>
                    <button type="button" class="btn btn-outline-success" onclick="llenarCarrito()"  data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="img/carrito-de-compras.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top"></button>
                  </div>
                </div>
              </div>
            </nav>
            <!--NAVBAR-->
        `;
    }
}

customElements.define('menu-component', Menu);