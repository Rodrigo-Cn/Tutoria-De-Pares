function validarFormulario() {

            var nome = document.forms["editarTutorado"]["nome"].value;
            var email = document.forms["editarTutorado"]["email"].value;
            var curso = document.forms["editarTutorado"]["curso"].value;
            var semestre = document.forms["editarTutorado"]["semestre"].value;
            var matricula = document.forms["editarTutorado"]["matricula"].value;
            var deficiencia = document.forms["editarTutorado"]["deficiencia"].value;

            if (nome === "" || email === "" || curso === "" || semestre === "" || matricula === "" || deficiencia === "") {
                document.getElementById("mensagemDeErro").innerHTML = "Preencha todos os campos!";
            return false;
            }

            return true;
        }