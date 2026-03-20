function ejecutar() {

    var segundos = Number(document.getElementById("tiempo").value);
    if (!segundos || segundos <= 0) {
        alert("Por favor ingrese un número válido");
        return;
    }
    var tiempoBase = segundos * 1000;
    var contenedor = document.getElementById("resultado");

    contenedor.innerHTML = "Por favor espere los resultados...<br><br>";
   
    setTimeout(function() {
        alert("Han pasado " + segundos + " segundos");
    }, tiempoBase);

   
    function crearPromesa(numero) {
        var aleatorio = Math.floor(Math.random() * 101);
        var tiempoFinal = tiempoBase + aleatorio;
        return new Promise(function(resolve) {
            setTimeout(function() {
                resolve("Promesa " + numero +
                        " terminó en " + tiempoFinal + " ms");
            }, tiempoFinal);
        });
    }

    crearPromesa(1).then(function(mensaje) {
        contenedor.innerHTML += mensaje + "<br>";
    });
    crearPromesa(2).then(function(mensaje) {
        contenedor.innerHTML += mensaje + "<br>";
    });
    crearPromesa(3).then(function(mensaje) {
        contenedor.innerHTML += mensaje + "<br>";
    });
}