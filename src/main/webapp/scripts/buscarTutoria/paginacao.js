document.addEventListener("DOMContentLoaded", function() {
    const elementos = document.querySelectorAll(".card");
    var indice = 0;
    var numero = 1;
    var numeroDaPagina = document.querySelector("#paginacao-num");

    var proxima = document.querySelector("#seta-direita");
    var anterior = document.querySelector("#seta-esquerda");

    iniciar();

    function iniciar() {
        verificarPagina();
        mostrarElementos();
    }

    function mostrarElementos() {
        for (var i = 0; i < elementos.length; i++) {
            elementos[i].classList.remove("tracking-in-expand");
            elementos[i].classList.remove("on");
        }

        for (var i = indice; i < indice + 4 && i < elementos.length; i++) {
            elementos[i].classList.add("tracking-in-expand");
            elementos[i].classList.add("on");
        }

        numeroDaPagina.textContent = numero;
    }

    proxima.addEventListener("click", function() {
        if (indice + 4 < elementos.length) {
            indice += 4;
            numero++;
            verificarPagina();
            scrollParaTop();
            mostrarElementos();
        }
    });

    anterior.addEventListener("click", function() {
        if (indice - 4 >= 0) {
            indice -= 4;
            numero--;
            verificarPagina();
            scrollParaTop();
            mostrarElementos();
        }
    });

    function verificarPagina() {
        if (numero === 1) {
            anterior.style.display = "none";
        } else if (numero === Math.ceil(elementos.length / 4)) {
            anterior.style.display = "block";
            proxima.style.display = "none";
        } else {
            proxima.style.display = "block";
            anterior.style.display = "block";
        }
    }
    function scrollParaTop() {
        window.scrollTo({
            top: 0
        });
    }
});
