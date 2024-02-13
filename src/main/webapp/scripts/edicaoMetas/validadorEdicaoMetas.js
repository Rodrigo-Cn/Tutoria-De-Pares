function validarFormulario() {

            var nome = document.forms["editarMeta"]["nome-criar"].value;
            var mensagem = "Digite o nome da meta!";
               if (nome === "") {
                mensagemErroElemento.innerHTML = mensagem;
                return false;
            }

            mensagemErroElemento.innerHTML = "";
            return true;
        }