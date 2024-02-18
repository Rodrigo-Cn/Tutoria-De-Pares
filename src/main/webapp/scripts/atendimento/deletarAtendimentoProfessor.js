function confirmar(codigoTutoria, id_atendimento) {
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


    window.location.href = "deletarAtendimentoProfessor?codigoTutoria=" + codigoTutoria + "&idAtendimento=" + id_atendimento;
    });
}