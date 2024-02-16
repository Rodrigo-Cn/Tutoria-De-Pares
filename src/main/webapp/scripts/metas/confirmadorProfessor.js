function confirmar(codigoMeta, codigo, id) {

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

        window.location.href = "deletarMetaProfessor?codigoMeta=" + codigoMeta + "&codigo=" + codigo + "&id=" + id;
    });
}