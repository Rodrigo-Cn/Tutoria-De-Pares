function validarFormulario() {

            var nome = document.forms["editarTutorado"]["nome"].value;
            var email = document.forms["editarTutorado"]["email"].value;
            var curso = document.forms["editarTutorado"]["curso"].value;
            var semestre = document.forms["editarTutorado"]["semestre"].value;
            var deficiencia = document.forms["editarTutorado"]["deficiencia"].value;
            var matricula = document.forms["editarTutorado"]["matricula"].value;


            if (nome === "" || email === "" || curso === "" || semestre === "" || deficiencia === "" || matricula === "") {
                document.getElementById("mensagemDeErro").innerHTML = "Preencha todos os campos!";
            return false;
            }

            return true;
        }