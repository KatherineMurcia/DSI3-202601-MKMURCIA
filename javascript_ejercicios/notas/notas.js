function crearInputs() {
  var cantidad = Number(document.getElementById("cantidad").value);
  var contenedor = document.getElementById("inputs");
  var boton = document.getElementById("btnCalcular");
  var mensaje = document.getElementById("mensaje");

  if (!cantidad || cantidad < 1 || cantidad > 50) {
    alert("Ingrese un número de estudiantes entre 1 y 50");
    contenedor.innerHTML = "";
    boton.classList.add("oculto");
    mensaje.textContent = "";
    return;
  }

  contenedor.innerHTML = "";
  mensaje.textContent = "Ingrese 3 notas por estudiante (0 a 100) y luego presione Calcular";

  for (var i = 0; i < cantidad; i++) {
    var div = document.createElement("div");
    div.className = "estudiante";

    div.innerHTML =
      "<div><b>Estudiante " + (i + 1) + "</b></div>" +
      "<input type='number' class='nota' min='0' max='100' placeholder='Nota 1'>" +
      "<input type='number' class='nota' min='0' max='100' placeholder='Nota 2'>" +
      "<input type='number' class='nota' min='0' max='100' placeholder='Nota 3'>" +
      "<span class='resultado'></span>";

    contenedor.appendChild(div);
  }

  boton.classList.remove("oculto");
}

function calcular() {
  var estudiantes = document.querySelectorAll(".estudiante");

  for (var i = 0; i < estudiantes.length; i++) {
    var notas = estudiantes[i].querySelectorAll(".nota");

    var n1 = Number(notas[0].value);
    var n2 = Number(notas[1].value);
    var n3 = Number(notas[2].value);

    var salida = estudiantes[i].querySelector(".resultado");

 
    if (!Number.isFinite(n1) || !Number.isFinite(n2) || !Number.isFinite(n3)) {
      salida.textContent = " Por favor complete las 3 notas";
      continue;
    }

    if (n1 < 0 || n1 > 100 || n2 < 0 || n2 > 100 || n3 < 0 || n3 > 100) {
      salida.textContent = " Por favor ingrese notas entre 0 y 100";
      continue;
    }

    var mayor = Math.max(n1, n2, n3);
    var menor = Math.min(n1, n2, n3);
    var media = n1 + n2 + n3 - mayor - menor;

    salida.textContent = " La nota media es: " + media;
  }
}