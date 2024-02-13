function confirmar(codigoMeta, codigo, id) {
    console.log("entrou")
    let elemento = document.getElementById("corpo-deletar-meta");
        elemento.classList.add("abrir-deletar");

        var fecharconfig = document.getElementById("fechar-deletar-meta");

        fecharconfig.addEventListener("click",desativartela);

        function desativartela(event){
            event.preventDefault();
            elemento.classList.remove("abrir-deletar");
        }


    var botaoSim = document.getElementById("sim");
    botaoSim.addEventListener("click", function() {
        console.log("entrou2")
        window.location.href = "deletarMetaNapne?codigoMeta=" + codigoMeta + "&codigo=" + codigo + "&id=" + id;
    });
}