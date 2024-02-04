function confirmar(codigo){
    let resposta = confirm("Confirma a exclusão dessa disciplina ?");
    if(resposta===true){
        window.location.href = "deletardisciplina?codigo=" + codigo;
    }
}