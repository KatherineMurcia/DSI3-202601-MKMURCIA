function crearInputs() {

  var cantidad = Number(document.getElementById("cantidad").value);
  var contenedor = document.getElementById("inputs");
  var mensaje = document.getElementById("mensaje");
  var boton = document.getElementById("btnCalcular");

  if (!cantidad || cantidad < 1 || cantidad > 100) {
    alert("Ingrese un número entre 1 y 100");
    contenedor.innerHTML = "";
    mensaje.innerHTML = "";
    boton.classList.add("oculto");
    return;
  }

  contenedor.innerHTML = "";
  mensaje.innerHTML = "Ingrese los goles de Brasil y Colombia en cada caso:";

  for (var i = 0; i < cantidad; i++) {
    var div = document.createElement("div");
    div.className = "caso";

    div.innerHTML =
      "<label><b>Caso " + (i + 1) + "</b></label><br>" +
      "<input type='number' class='brasil' min='0' placeholder='Brasil'>" +
      "<input type='number' class='colombia' min='0' placeholder='Colombia'>" +
      "<span class='resultado'></span>";

    contenedor.appendChild(div);
  }

  boton.classList.remove("oculto");
}

function calcular() {

  var casos = document.querySelectorAll(".caso");

  for (var i = 0; i < casos.length; i++) {
    var golesBrasil = Number(casos[i].querySelector(".brasil").value);
    var golesColombia = Number(casos[i].querySelector(".colombia").value);
    var resultado = casos[i].querySelector(".resultado");

    if (
      casos[i].querySelector(".brasil").value === "" ||
      casos[i].querySelector(".colombia").value === ""
    ) {
      resultado.innerHTML = "Complete ambos valores";
    } 
    else if (golesColombia > golesBrasil) {
      resultado.innerHTML = "ganamos";
    } 
    else if (golesBrasil > golesColombia) {
      resultado.innerHTML = "perdimos";
    } 
    else {
      resultado.innerHTML = "casi ganamos";
    }
  }
}