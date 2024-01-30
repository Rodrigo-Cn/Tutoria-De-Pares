function validarLoginDisciplina()
{
    const codigo = document.forms["form-entrar-tutoria"].elements["codigo"].value;

    if (codigo === "")
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
