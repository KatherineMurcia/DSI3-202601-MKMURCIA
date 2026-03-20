function calcularNota() {

    let notas = [
        Number(document.getElementById("n1").value),
        Number(document.getElementById("n2").value),
        Number(document.getElementById("n3").value),
        Number(document.getElementById("n4").value),
        Number(document.getElementById("n5").value),
        Number(document.getElementById("n6").value),
        Number(document.getElementById("n7").value),
        Number(document.getElementById("n8").value)
    ];

    let pesos = [0.05, 0.10, 0.10, 0.10, 0.15, 0.15, 0.15, 0.20];

    for (let i = 0; i < notas.length; i++) {

        if (isNaN(notas[i])) {
            alert("Por favor ingrese todas las notas");
            return;
        }

        if (notas[i] < 0 || notas[i] > 5) {
            alert("Recuerde que las notas deben estar entre 0 y 5");
            return;
        }

    }

    let final = 0;

    for (let i = 0; i < notas.length; i++) {
        final += notas[i] * pesos[i];
    }

    document.getElementById("resultado").innerText =
        "Nota Final: " + final.toFixed(2);

}