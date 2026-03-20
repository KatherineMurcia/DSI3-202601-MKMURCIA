function crearSelects(){

var cantidad = Number(document.getElementById("cantidad").value);
var contenedor = document.getElementById("selects");
var boton = document.getElementById("btnCalcular");
var mensaje = document.getElementById("mensaje");

if(!cantidad || cantidad < 1 || cantidad > 100){
alert("Ingrese un número entre 1 y 100");
return;
}
contenedor.innerHTML="";

mensaje.innerHTML = "Seleccione los ganadores de cada juego:";

for(var i=0;i<cantidad;i++){

var label = document.createElement("label");
label.innerHTML = "Juego " + (i+1);

var select = document.createElement("select");

select.appendChild(new Option("ALICE","ALICE"));
select.appendChild(new Option("BOB","BOB"));
select.appendChild(new Option("EMPATE","EMPATE"));

contenedor.appendChild(label);
contenedor.appendChild(select);

}

boton.classList.remove("oculto");

}

function calcular(){
var selects = document.querySelectorAll("#selects select");
var puntosAlice=0;
var puntosBob=0;
var empates=0;

for(var i=0;i<selects.length;i++){

var valor = selects[i].value;

if(valor==="ALICE"){
puntosAlice+=2;
}

else if(valor==="BOB"){
puntosBob+=2;
}

else{
puntosAlice+=1;
puntosBob+=1;
empates++;
}

}

var contenedorResultados = document.getElementById("resultados");

contenedorResultados.innerHTML=
"<b>Puntos Alice:</b> "+puntosAlice+
"<br><b>Puntos Bob:</b> "+puntosBob+
"<br><b>Empates:</b> "+empates;

if(puntosAlice>puntosBob){
alert("ALICE");
}

else if(puntosBob>puntosAlice){
alert("BOB");
}

else{
alert("EMPATE");
}

}