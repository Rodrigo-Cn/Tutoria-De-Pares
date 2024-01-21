function validarLoginTutoria()
{
    const codigo = document.forms["form-entrar-tutoria"].elements["codigo"].value;
    const senha = document.forms["form-entrar-tutoria"].elements["senha"].value;

    if (codigo === "" || senha === "")
    {
    console.log("ENTROU NA CONDIÇÃO");
        document.getElementById("mensagemDeErro").innerHTML = "Preencha todos os campos!";
        return false;
    } else
    {
        document.forms["form-entrar-tutoria"].submit();
        return true;
    }
}
