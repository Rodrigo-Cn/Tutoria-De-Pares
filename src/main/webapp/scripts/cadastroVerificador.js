function mostrarOcultarMatricula() {
    var tipoUsuario = document.getElementById("form3Example5c");
    var matriculaInput = document.getElementById("form3Example6c"); // ID do input de matrícula
    var funcaoInput = document.getElementById("form3Exampl7c");
    var labelFuncao = document.getElementById("labelFuncao"); // ID do rótulo da matrícula

    
    if (tipoUsuario.value === "aluno") {
      matriculaInput.style.display = "block";
      funcaoInput.style.display = "block";
      labelFuncao.style.display = "block";
    } else {
      matriculaInput.style.display = "none";
      funcaoInput.style.display = "none";
      labelFuncao.style.display = "none";
    }
  }
  