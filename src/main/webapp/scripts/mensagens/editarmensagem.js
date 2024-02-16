var editar = document.querySelector(".iniciar-config");

editar.addEventListener("click", function(event) {
    event.preventDefault();
    var corpo = document.querySelector("#body-editar-mensagem");
    corpo.style.display = "flex";
    rolarParaCima();
});

function rolarParaCima() {
    if (document.documentElement.scrollTop > 0) {
        document.documentElement.scrollTop = 0;
    } else if (document.body.scrollTop > 0) {
        document.body.scrollTop = 0;
    }
}
