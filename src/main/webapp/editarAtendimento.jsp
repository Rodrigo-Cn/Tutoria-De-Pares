<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="main.model.Atendimento" %>
<%@ page import="main.dao.AtendimentoDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
    <link rel="stylesheet" href="styles/editarAtendimento/editarAtendimento.css">
    <script src="https://kit.fontawesome.com/bfe249254a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-ZszwtZ2O1b5GZYG8waGIB+S0xGjH5+8h7v4lG2acK5X5KbwD/3Sd7U3HxbSjg4Qhno2cA5wXtxa/FR1u7hzfgg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Editar Atendimento</title>
</head>
<body>
<div vw class="enabled">
    <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
        <div class="vw-plugin-top-wrapper"></div>
    </div>
</div>
<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
</script>
    <div id="navbar">
        <div id="navbar-logo">
          <div> <a href=""> <img src="imagens/cadastro/Frame 1.png" id="navbar-image" alt="frame.png"></a></div>
          <div id="navbar-name"> <a href=""> <p>Tutoria</p><p>De</p><p>Pares</p> </a></div>
        </div>

         <div id="navbar-inicio">
              <a href="" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/cadastrarNapne/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
              <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/cadastrarNapne/icons8-usuário-96.png" alt="">
              <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
              </div>
      </div>


      <div id="container-main">
        <div id="container-conteudo">
                <form action="editarAtendimentoNapne" method="post">
                                    <div class="form-header">
                                        <div class="title">
                                            <h1>Editar Atendimento</h1>
                                        </div>

                                        <div class="warning">
                                            <h3 style="color: red">As op&ccedil;&otilde;es com um <i class="fa-solid fa-asterisk" style="color: red"></i> s&atilde;o obrigat&oacute;rias</h3>
                                        </div>


                                        <div class="clip">
                                            <i class="fa-solid fa-paperclip fa-6x" style="color: #127475; transform: rotate(135deg);"></i>
                                        </div>
                                    </div>

                                    <div class="warning2">
                                        <h3 style="color: red">Todos os campos s&atilde;o obrigat&oacute;rios</h3>
                                    </div>

                                    <div class="half" id="icones">
                                        <div class="form-grupo">
                                            <i class="fa-solid fa-asterisk" style="color: red"></i>
                                        </div>

                                        <div class="form-grupo">
                                            <i class="fa-solid fa-asterisk" style="color: red"></i>
                                        </div>

                                        <div class="form-grupo">
                                            <i class="fa-solid fa-asterisk" style="color: red"></i>
                                        </div>
                                    </div>
                                    <div class="half">
                                        <div class="form-grupo" id="senha">
                                             <input class="form-input" type="date" name="date" value="<%= ((Atendimento) request.getAttribute("atendimento")).getData() %>" required>
                                        </div>


                                        <div class="form-grupo">
                                            <input class="form-input" type="number" name="cargaHoraria" placeholder="Carga horária" value="<%= ((Atendimento) request.getAttribute("atendimento")).getCargaHoraria() %>" required>
                                            <i class="fa-solid fa-clock icones"></i>
                                        </div>

                                        <div class="form-grupo" id="senha">
                                            <input class="form-input" type="time" name="horario" value="<%= ((Atendimento) request.getAttribute("atendimento")).getHorario() %>" required>
                                       </div>

                                    </div>

                                    <div class="half" id="icones">
                                        <div class="form-grupo">
                                            <i class="fa-solid fa-asterisk" style="color: red"></i>
                                        </div>

                                        <div class="form-grupo">
                                            <i class="fa-solid fa-asterisk" style="color: red"></i>
                                        </div>
                                    </div>

                                    <div class="half">
                                        <div class="form-grupo" id="disciplina">
                                            <input class="form-input" type="text" name="local" placeholder="Local" value="<%= ((Atendimento) request.getAttribute("atendimento")).getLocal() %>" required>
                                            <i class="fa-solid fa-location-dot icones"></i>
                                        </div>

                                        <div class="form-grupo">
                                            <input class="form-input" type="text" name="id2" style="display:none;" value="<%= ((Atendimento) request.getAttribute("atendimento")).getId() %>" required>
                                            <input class="form-input" type="text" name="conteudoTratado" placeholder="Conteúdo tratado" value="<%= ((Atendimento) request.getAttribute("atendimento")).getConteudo() %>" required>
                                            <i class="fa-solid fa-book icones"></i>
                                        </div>
                                    </div>

                                    <div class="mensagem" id="mensagemDoBack">
                                        <h3>  </h3>
                                    </div>


                                <footer id="main-footer">
                                    <button id="button-submit" type="submit">
                                        EDITAR
                                    </button>


                                </footer>
                                </form>

        </div>
       </div>

      <div id="div-area">
        <div id="div-area-footer1">
          <div id="div-area-image1">
            <img id="image-main-footer" src="imagens/cadastro/Frame 1.png" alt="">
          </div>
          <div id="div-area-image2">
            <a href=""><img src="imagens/cadastro/icons8-facebook-50 1.png" alt=""></a>
            <a href=""><img src="imagens/cadastro/icons8-instagram-64 1.png" alt=""></a>
            <a href=""><img src="imagens/cadastro/icons8-linkedin-50 1.png" alt=""></a>
          </div>
        </div>
        <div id="div-area-footer2">
          <strong><p style="font-size: 1.3rem; height: 80%;">Informa&ccedil;&otilde;es:</p></strong>
          <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
          <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
        </div>
      </div>
    </div>

    <script src="menu-entrar-tutoria.js"></script>
    <script src="barra-lateral.js"></script>
    <script src="cards.js"></script>
    <script src="scripts/criarTutoria/popup.js"></script>
</body>
</html>