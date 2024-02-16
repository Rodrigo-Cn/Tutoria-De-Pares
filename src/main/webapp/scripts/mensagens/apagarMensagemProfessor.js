function confirmar(codigoMeta, codigo, id, codigoMensagem) {
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


    window.location.href = "deletarMensagemProfessor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigo + "&id=" + id + "&codigoMensagem=" + codigoMensagem;
    });
}