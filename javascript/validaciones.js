function validar() {

    let nombre = document.getElementById("nombre").value;
    let edad = document.getElementById("edad").value;
    let nota = document.getElementById("nota").value;

    // Saludo
    alert("Hola " + nombre);

    // Mayor o menor de edad
    if (edad >= 18) {
        alert("Eres mayor de edad");
    } else {
        alert("Eres menor de edad");
    }

    // Aprobó o reprobó
    if (nota >= 3) {
        alert("Aprobó");
    } else {
        alert("Reprobó");
    }
}