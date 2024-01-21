function validar() {
    var login = document.getElementById("input-text1").value;
    var senha = document.getElementById("input-text2").value;
    var entrada = document.getElementById("entrada1");

    if (login === "") {
        entrada.innerHTML = "Preencha o campo usuário.";
        document.getElementById("input-text1").focus();
        return false;
    } else if (senha === "") {
        entrada.innerHTML = "Preencha o campo senha.";
        document.getElementById("input-text2").focus();
        return false;
    } else {
        alert("Contato Adicionado com Sucesso!");
        document.forms["login"].submit();
    }
}

var passwordInput = document.getElementById("img-password");
var passwordText = document.getElementById("input-text2");
passwordInput.addEventListener("click", function() {
    if (passwordInput.src.endsWith("imagens/login/olho(1).png")) {
        passwordInput.src = "imagens/login/olho.png";
        passwordText.type = "text";
    } else {
        passwordInput.src = "imagens/login/olho(1).png";
        passwordText.type = "password";
    }
});





