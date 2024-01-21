function mostrarOcultarMatricula() {
    var tipoUsuario = document.getElementById("form3Example5c");
    var matriculaInput = document.getElementById("form3Example6c");
    var funcaoInput = document.getElementById("form3Example7c");
    var labelFuncao = document.getElementById("labelFuncao");
    var labelMatricula = document.getElementById("labelMatricula");


    if (tipoUsuario.value === "aluno") {
      matriculaInput.style.display = "block";
      funcaoInput.style.display = "block";
      labelFuncao.style.display = "block";
      labelMatricula.style.display = "block"
    } else {
      matriculaInput.style.display = "none";
      funcaoInput.style.display = "none";
      labelFuncao.style.display = "none";
      labelMatricula.style.display = "none"
    }
  }
  