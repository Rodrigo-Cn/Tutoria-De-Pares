var configs = document.querySelectorAll(".editar");

configs.forEach(function(config) {
    config.addEventListener("click", ativartelaconfig);
});

var fecharconfig = document.getElementById("fechar-editar-meta");

fecharconfig.addEventListener("click", desativartelaconfig);

function ativartelaconfig(event) {

    var corpo = document.getElementById("corpo-editar-meta");
    rolarparacima();
    corpo.style.display = "flex";
}

function desativartelaconfig(event) {
    event.preventDefault();
    var corpo = document.getElementById("corpo-editar-meta");
    corpo.style.display = "none";
}

function rolarparacima() {
    window.scroll({
        top: 0,
        left: 0,
        behavior: "smooth"
    });
}
