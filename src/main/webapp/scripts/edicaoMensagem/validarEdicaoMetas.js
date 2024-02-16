function validarFormulario() {

            var nome = document.forms["editar-mensagem"]["mensagem"].value;
            var mensagem = "Digite a mensagem!";
               if (nome === "") {
                mensagemErro.innerHTML = mensagem;
                return false;
            }

            mensagemErro.innerHTML = "";
            return true;
        }