function crearCasos() {

    let cantidad = Number(document.getElementById("cantidad").value);
    let contenedor = document.getElementById("casos");
    let mensaje = document.getElementById("mensaje");
    let boton = document.getElementById("btnCalcular");

    if (!cantidad || cantidad < 1 || cantidad > 100) {

        alert("Ingrese un número entre 1 y 100");

        contenedor.innerHTML = "";
        mensaje.innerHTML = "";
        boton.classList.add("oculto");

        return;
    }

    contenedor.innerHTML = "";

    mensaje.innerHTML = "Ingrese los valores del conector y tomacorriente (solo 0 o 1)";

    for (let i = 0; i < cantidad; i++) {

        let html = `

        <div class="caso">

        <h3>Caso ${i + 1}</h3>

        <div class="contenedor">

        <div class="bloque">

        <label>Conector</label>

        <div class="linea">

        <input type="number" class="conector" min="0" max="1">
        <input type="number" class="conector" min="0" max="1">
        <input type="number" class="conector" min="0" max="1">
        <input type="number" class="conector" min="0" max="1">
        <input type="number" class="conector" min="0" max="1">
        <input type="number" class="conector" min="0" max="1">

        </div>

        </div>

        <div class="bloque">

        <label>Tomacorriente</label>

        <div class="linea">

        <input type="number" class="toma" min="0" max="1">
        <input type="number" class="toma" min="0" max="1">
        <input type="number" class="toma" min="0" max="1">
        <input type="number" class="toma" min="0" max="1">
        <input type="number" class="toma" min="0" max="1">
        <input type="number" class="toma" min="0" max="1">

        </div>

        </div>

        </div>

        <p class="resultado"></p>

        </div>

        `;

        contenedor.innerHTML += html;

    }

    boton.classList.remove("oculto");

}



function calcularCompatibilidad() {

    let casos = document.querySelectorAll(".caso");

    casos.forEach(caso => {

        let conectores = caso.querySelectorAll(".conector");
        let tomas = caso.querySelectorAll(".toma");
        let resultado = caso.querySelector(".resultado");

        let compatible = true;

        for (let i = 0; i < 6; i++) {

            let c = conectores[i].value;
            let t = tomas[i].value;

            if (c === "" || t === "") {

                resultado.innerHTML = "Complete todos los valores";
                resultado.style.color = "red";
                return;

            }

            if ((c !== "0" && c !== "1") || (t !== "0" && t !== "1")) {

                resultado.innerHTML = "Solo se permiten valores 0 y 1";
                resultado.style.color = "red";
                return;

            }

            if (c === t) {

                compatible = false;

            }

        }

        if (compatible) {

            resultado.innerHTML = "COMPATIBLE";
            resultado.style.color = "green";

        } else {

            resultado.innerHTML = "INCOMPATIBLE";
            resultado.style.color = "red";

        }

    });

}