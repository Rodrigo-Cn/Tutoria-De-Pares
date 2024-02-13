var titulo = document.getElementById("titulo-meta");
var mensagemErroElemento = document.getElementById("mensagemErro");

document.getElementById("botao-enviar").addEventListener("click", verificarTituloMeta);

function verificarTituloMeta() {
    var mensagem = "Digite o nome da meta!";
    if (titulo.value === "") {
        mensagemErroElemento.innerHTML = mensagem;
    } else {
        mensagemErroElemento.innerHTML = "";
        document.forms["criarMeta"].submit();
    }
}
