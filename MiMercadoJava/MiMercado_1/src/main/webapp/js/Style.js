var i;
function contadormas(iddeinput){ 
    var cant = document.getElementById(iddeinput); 
    if(cant.value>=2){
        i = cant.value;
    }else{
        if(cant.value == "1"){i = 1;}
    }
    i++; 
    cant.value = i;
}
function contadormenos(iddeinput){
    var cant = document.getElementById(iddeinput); 
    if(cant.value>2){
        i = cant.value;
        i--;
        cant.value = i;
    }else{
        cant.value="1";
    }
}