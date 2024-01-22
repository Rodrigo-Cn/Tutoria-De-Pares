function validar(){
    let ocupacao = frmUsuario.ocupacao.value;
    let nome = frmUsuario.nome.value;
    let email = frmUsuario.email.value;
    let matricula = frmUsuario.matricula.value;
    let senha = frmUsuario.senha.value;
    let senhaRepetida = frmUsuario.senhaRepetida.value;
    let termos = frmUsuario.termos.checked;

    if( ocupacao === "aluno")
    {
        if(nome === "" || email === "" || matricula === "" || senha === "" || senhaRepetida === "" || !termos)
        {
            alert("Preencha todos os campos!");
            return false;
        }
        else if(senha !== senhaRepetida)
        {
            alert("As senhas devem ser iguais!")
            return false;
        }
        else
        {
            alert("Cadastro Realizado com Sucesso.");
            document.forms["frmUsuario"].submit();
        }
    }
    else
    {
        if(nome === "" || email === "" || senha === "" || senhaRepetida === "" || !termos)
        {
            alert("Preencha todos os campos!");
            return false;
        }
        else if(senha !== senhaRepetida)
        {
            alert("As senhas devem ser iguais!")
            return false;
        }
        else
        {
            alert("Cadastro Realizado com Sucesso.");
            document.forms["frmUsuario"].submit();
        }
    }
}
