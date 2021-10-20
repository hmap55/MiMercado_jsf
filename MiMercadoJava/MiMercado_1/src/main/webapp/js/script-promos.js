//carga de datos iniciales



function cargarDatos(){
  let carrito = document.getElementById("total-carrito");
  let compra = parseInt(carrito.innerHTML);
  if (localStorage.length == 0){
    localStorage.setItem("compra", compra);
  }
  else{
    let compra_actual = localStorage.getItem("compra");
    carrito.innerHTML = compra_actual;
  }


}









/** transaccion de datos del formulario promos a la pagina de producto */

//detectando el elemento al que se hace click

let num_items = document.querySelectorAll(".main-productos-contenido");
let tarjeta;
let url;
let elementStyle;
let elementImage;
let precio;


const info_item = function(){
  tarjeta = parseInt(this.dataset.item);
  //extrayendo imagen del elemento seleccionado

  //datos a extraer
  url = document.querySelectorAll(".main-productos-img")[tarjeta];
  nombre = document.querySelectorAll(".main-productos-titulo")[tarjeta].innerHTML;
  precio = document.querySelectorAll(".precio")[tarjeta].innerHTML;
 

  console.log(url);
  console.log(nombre);
  console.log(precio);

  //asignacion de imagen
  elementStyle =  window.getComputedStyle(url);
  elementImage = elementStyle.getPropertyValue('background-image');

  //almacenando en memoria local
  localStorage.setItem("url", elementImage);
  localStorage.setItem("nombre", nombre);
  localStorage.setItem("precio", precio);

  //almacenando valor de compra actual
  

  
}

num_items.forEach (item => item.addEventListener("click", info_item));


function captura_click(){

  location.href="/html/index-producto.html";
  //document.onclick = function (){
    //console.log(event.srcElement);
  //}
  //console.log(this.dataset.item);


}


//cierre o recarga de pagina


