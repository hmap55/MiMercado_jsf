let num_items = document.querySelectorAll(".card");
let tarjeta;
let url;
let elementStyle;
let elementImage;
let precio;


const info_item = function(){
  tarjeta = parseInt(this.dataset.item);
  //extrayendo imagen del elemento seleccionado

  //datos a extraer
  url = document.querySelectorAll(".card-image")[tarjeta];
  nombre = document.querySelectorAll(".card-titulo")[tarjeta].innerHTML;
  precio = document.querySelectorAll(".card-precio")[tarjeta].innerHTML;
 

  console.log(url);
  console.log(nombre);
  console.log(precio);

  //asignacion de imagen
 
  elementImage = url.src;
  console.log(elementImage);

  //almacenando en memoria local
  localStorage.setItem("url","url(" + elementImage + ")");
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