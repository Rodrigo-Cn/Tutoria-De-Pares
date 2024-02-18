<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.model.Tutor" %>
<%@ page import="main.model.Tutorado" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.TutoradoDao" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
    <link rel="stylesheet" href="styles/criarTutoria/criarTutoria.css">
    <script src="https://kit.fontawesome.com/bfe249254a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-ZszwtZ2O1b5GZYG8waGIB+S0xGjH5+8h7v4lG2acK5X5KbwD/3Sd7U3HxbSjg4Qhno2cA5wXtxa/FR1u7hzfgg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Criar Tutoria</title>
</head>
<body>
    <div id="navbar">
        <div id="navbar-logo">
          <div> <a href="voltarParaMainNapne?id=<%= request.getParameter("id")%>"> <img src="imagens/cadastro/Frame 1.png" id="navbar-image" alt="frame.png"> </a></div>
          <div id="navbar-name"> <a href="voltarParaMainNapne?id=<%= request.getParameter("id")%>"> <p>Tutoria</p><p>De</p><p>Pares</p> </a></div>
        </div>

         <div id="navbar-inicio">
              <a href="voltarParaMainNapne?id=<%= request.getParameter("id")%>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/cadastrarNapne/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
              <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/cadastrarNapne/icons8-usuário-96.png" alt="">
              <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
              </div>
      </div>


      <div id="container-main">
        <div id="container-conteudo">
                <form action="realizarEdicaoTutoria">
                    <div class="form-header">

                        <div class="title">
                            <h1>Editar Tutoria</h1>
                        </div>

                        <div class="clip">
                            <i class="fa-solid fa-paperclip fa-6x" style="color: #127475; transform: rotate(135deg);"></i>
                        </div>
                    </div>

                    <div class="half">
                        <div class="form-grupo" id="senha">
                            <label> Digite a nova senha </label>
                             <input class="form-input" type="text" name="senha" value="<%out.print(((Tutoria) request.getAttribute("tutoria")).getSenha());%>"  required>
                        </div>
                    </div>

                    <div class="half">
                        <div class="form-grupo">
                        <label> Digite o novo ID do tutorado </label>
                            <input class="form-input" type="number" name="idTutorado" value="<%out.print(((Tutoria) request.getAttribute("tutoria")).getTutorado().getId());%>">
                        </div>
                    </div>

                     <div class="half">
                        <div class="form-grupo" id="senha">
                          <label> Digite o novo ID do tutor </label>
                          <input class="form-input" type="number" name="idTutor" value="<%out.print(((Tutoria) request.getAttribute("tutoria")).getTutor().getId());%>">
                        </div>
                      </div>

                      <input class="form-input" style="visibility: hidden;" type="number" name="codigo" value="<%out.print(((Tutoria) request.getAttribute("tutoria")).getCodigo());%>">



                <% if (request.getAttribute("mensagem") != null && !request.getAttribute("mensagem").equals("sucesso")) { %>
                    <div class="mensagem" id="mensagemDoBack">
                        <h3> <%= request.getAttribute("mensagem") %> </h3>
                    </div>
                <% } %>


                <footer id="main-footer">
                    <button id="button-submit" type="submit">
                        CRIAR
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