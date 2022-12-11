const toastTrigger = document.querySelector('.liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')

const productos = [];
const carrito = [];



function getAllUsers(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/api/v1/usuarios"
    }).done(function(data) {
        data.forEach( d =>{
           console.log(d);
        });
        alert(data); // imprimimos la respuesta
    }).fail(function(e) {
        console.log(e);
        alert("Algo salió mal");
    }).always(function() {
        alert("Siempre se ejecuta")
    });
}

cargarProductos();

function cargarProductos(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/api/v1/productos"
    }).done(function(data) {
        let cards = "";
        
        data.forEach( d =>{
            productos.push(d);
           cards += 
           `
         <div class="col">
            <div class="card card${d.id} h-100">
                <img src="img/imgGorro.jpeg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${d.nombre}</h5>
                    <p class="card-text">${d.precio}</p>
                    <button type="button" onclick="mostrarToast('${d.id}')" class="btn btn-warning liveToastBtn" ">Agregar al carrito</button>
                </div>
            </div>
        </div>

           `;
        });
        document.querySelector('.contenedorPadre').innerHTML = cards;
        // alert(data); // imprimimos la respuesta
    }).fail(function(e) {
        console.log(e.obj);
        alert("Algo salió mal");
    }).always(function() {
        // alert("Siempre se ejecuta")
    });


}

function mostrarToast(event){
    // console.log(event.nombre);
    getFilteredByKey(productos, "id", event);
    const toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}

function getFilteredByKey(array, key, value) {
    array.forEach(function(e) {
        if(e[key] == value){
            
            if(getFilteredByKey2(carrito, key, value).length > 0){
                alert("ya agregaste esteproducto");
            }else{
                e["cantidad"] = 1;
                carrito.push(e);
            }
            return;
        }
    });
  }

  function getFilteredByKey2(array, key, value) {
    return array.filter(function(e) {
      return e[key] == value;
    });
  }

  function cotizar(){
        if(localStorage.getItem("sesion") !== 'activa'){
            alert("Porfavor inicia sesion para continuar");
            return;
        }
      window.location.href = 'http://localhost:63342/aplicacion-cotizacion-productos/static/mensajeriaWpp.html'
  }

  function llenarCarrito(){
    let body = document.querySelector("#dataTable");
    let items = `
                <thead>
                    <tr>
                      <th>Imagen</th>
                      <th>Producto</th>
                      <th>Valor(c/a)</th>
                      <th>Valor Total</th>
                      <th>Opciones</th>
                      </tr> 
                </thead>
                <tbody>`;
      carrito.forEach( carritoKey =>{
          items += `
                <tr>
                    <td><img width="90px" src="img/imgGorro.jpeg" alt="nothing"></td>
                    <td>${carritoKey.nombre}</td>
                    <td>${carritoKey.precio}</td>
                    <td>${carritoKey.precio}</td>
                    <td class="d-flex">
                         <h5>${carritoKey.cantidad}</h5>
                    </td>
                </tr>
          `;
      });
      items+= "</tbody>"
      body.innerHTML = items;
  }




  function sumar(id){
      let item = getFilteredByKey2(carrito, "id", id);
      // console.log(item);
      let temp = item[0].cantidad = item[0].cantidad + 1;
      // console.log(item[0]);
      let index = carrito.indexOf(item[0]);
      carrito[index] = temp;
      console.log(item[index]);

  }
