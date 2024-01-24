var buscar1 = document.getElementById("buscar-section");
var buscar2 = document.getElementById("lupa-section");
var campoDeBusca = document.getElementById("input-section");

buscar1.addEventListener("click", buscar);
buscar2.addEventListener("click", buscar);
campoDeBusca.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        buscar();
    }
});

function buscar() {
    document.forms["busca"].submit();
}
