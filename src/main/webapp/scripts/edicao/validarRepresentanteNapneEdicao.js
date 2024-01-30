function validarFormulario() {

            var nome = document.forms["editarTutorado"]["nome"].value;
            var email = document.forms["editarTutorado"]["email"].value;


            if (nome === "" || email === "") {
                document.getElementById("mensagemDeErro").innerHTML = "Preencha todos os campos!";
            return false;
            }

            return true;
        }