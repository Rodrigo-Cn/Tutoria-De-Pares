var buscar = document.getElementById("section-botao");

buscar.addEventListener("click", function () {

    var nomeDisciplina = document.getElementsByName("nome-disciplina")[0];

    if (nomeDisciplina.value.trim() === "") {
        alert("Preencha o Campo Nome/Semestre de Disciplina.");
        nomeDisciplina.focus();
    }  else {
        document.forms["editar-disciplina"].submit();
    }

});