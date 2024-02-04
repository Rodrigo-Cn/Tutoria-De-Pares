var sair = document.querySelector("#sec-image");
var shadow = document.querySelector("#nav-shadow");
var entrar = document.querySelector("#section-image");

sair.addEventListener("click",function(){
    shadow.style.display = "none";
});

entrar.addEventListener("click",function(){
    shadow.style.display = "flex";
});

var mensagem = document.getElementById("sec-entrar-input3");
var buscar = document.getElementById("sec-button");

buscar.addEventListener("click", function () {

    var codigoProfessor = document.getElementsByName("codigo-professor")[0];
    var nomeDisciplina = document.getElementsByName("nome-disciplina")[0];

    if (nomeDisciplina.value.trim() === "") {
        nomeDisciplina.focus();
        mensagem.innerHTML = "Preencha todos os campos.";
    } else if (codigoProfessor.value.trim() <= 0 && codigoProfessor.value.trim() !==  "") {
        codigoProfessor.focus();
        mensagem.innerHTML = "Código inválido.";
    }  else {
        document.forms["criar-disciplina"].submit();
    }

});