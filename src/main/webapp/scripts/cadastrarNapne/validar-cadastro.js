var mensagem = document.getElementById("section-mensagem");
var buscar = document.getElementById("buscar-section");

buscar.addEventListener("click", function () {

    var nome = document.getElementsByName("nome")[0];
    var email = document.getElementsByName("email")[0];
    var senha1 = document.getElementsByName("senha1")[0];
    var senha2 = document.getElementsByName("senha2")[0];

    if (nome.value.trim() === "") {
        nome.focus();
        mensagem.innerHTML = "Preencha todos os campos.";
    } else if (email.value.trim() === "") {
        email.focus();
        mensagem.innerHTML = "Preencha todos os campos.";
    } else if (senha1.value.trim() === "") {
        senha1.focus();
        mensagem.innerHTML = "Preencha todos os campos.";
    } else if (senha2.value.trim() === "") {
        senha2.focus();
        mensagem.innerHTML = "Preencha todos os campos.";
    } else if (senha2.value.trim() !== senha1.value.trim()) {
        senha2.focus();
        mensagem.innerHTML = "Senhas não coincidem.";
    } else {
        alert("Cadastro realizado com sucesso!");
        document.forms["cadastrar-profissional"].submit();
    }

});
