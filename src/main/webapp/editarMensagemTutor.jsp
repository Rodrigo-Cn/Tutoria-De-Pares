<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Tutor" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.model.Meta" %>
<%@ page import="main.model.Mensagem" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mensagens</title>
</head>
<link rel="stylesheet" href="styles/mensagens/mensagens.css">

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
    <script src="scripts/mensagens/editarmensagem.js" defer></script>
    <%
      Mensagem mensagem = (Mensagem) request.getAttribute("mensagem");
    %>
    <div id="body-editar-mensagem" style="display: flex;">
        <form id="editar-mensagem" action="editarMensagemTutor" onsubmit="return validarFormulario()">
            <div id="editar-mensagem-title">
                <div style="width: 90%;">
                    <h2 style="margin-left: 34%;">Editar Mensagem</h2>
                </div><a href="carregarMensagensTutor?codigoMeta=<%=((Meta) request.getAttribute("meta")).getCodigo()%>&codigoTutoria=<%=((Tutoria) request.getAttribute("tutoria")).getCodigo()%>&id=<%= ((Tutor) request.getAttribute("tutor")).getId() %>"><img src="imagens/mensagens/icons8-fechar-janela-48.png" alt=""></a>
            </div>
            <input type="hidden" name="codigoMensagem" id="input-editar-msg" value="<%= mensagem.getCodigoMensagem() %>">
            <input type="hidden" name="codigoMeta" id="input-editar-msg" value="<%= request.getParameter("codigoMeta") %>">
            <input type="hidden" name="codigoTutoria" id="input-editar-msg" value="<%= request.getParameter("codigoTutoria") %>">
            <input type="text" name="mensagem" id="input-editar-msg" value="<%= mensagem.getMsg() %>">
            <h1 id="mensagemErro" style="color: red"></h1>
            <input type="submit" value="Editar" id="button-editar-msg">
        </form>
    </div>

    <div id="navbar">
        <div id="navbar-logo">
            <div> <a href=""> <img src="imagens/mensagens/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div> </a>
            <div id="navbar-name" class="tracking-in-expand-forward-top">
                <p>Tutoria</p>
                <p>De</p>
                <p>Pares</p>
            </div>
        </div> </a>
        <div id="navbar-inicio">
            <a href=""><img id="navbar-image2" class="tracking-in-expand-forward-top"
                    src="imagens/mensagens/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
            <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3"
                src="imagens/mensagens/usu96.png" alt="">
            <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((Tutor) request.getAttribute("tutor")).getNome().split(" ")[0] %></h2>
        </div>
    </div>

    <div id="section">
        <div id="section-title">
            <h1>Meta: <%= ((Meta) request.getAttribute("meta")).getTitulo() %> </h1>
        </div>
        <div id="section-card">

         <%
                    int idTutor = ((Tutor) request.getAttribute("tutor")).getId();
                 %>

            <% if( ((Meta) request.getAttribute("meta")).getMensagens().size()==0 ) { %>
              <div class="card">
                  <div class="title-card">
                      <div class="title-card-usuario">
                           <img class="card-image" src="imagens/mensagens/homi.png" alt="">
                             Tutoria de Pares
                      </div>
                      <div class="title-card-options">

                      </div>
                  </div>
                     <div class="body-card">
                               Inicie uma conversa!
                      </div>
              </div>

            <% } else { %>

                <% for(int i=0; i<((Meta) request.getAttribute("meta")).getMensagens().size(); i++) { %>
                    <div class="card">
                         <div class="title-card">
                              <div class="title-card-usuario">
                                   <img class="card-image" src="imagens/mensagens/homi.png" alt="">
                                   <%=  ((Meta) request.getAttribute("meta")).getMensagens().get(i).getUsuario().getNome() %>
                              </div>
                              <div class="title-card-options">
                                   <% if( idTutor==((Meta) request.getAttribute("meta")).getMensagens().get(i).getUsuario().getId() ) { %>
                                   <a href=""><img id="iniciar-config" class="iniciar-config" src="imagens/mensagens/config.png" alt=""></a>
                                   <a onclick=""><img src="imagens/mensagens/icons8-lixo-50.png" alt=""></a>
                                   <% } %>
                              </div>
                         </div>
                         <div class="body-card">
                              <%= ((Meta) request.getAttribute("meta")).getMensagens().get(i).getMsg() %>
                         </div>
                    </div>
                <% } %>

            <% } %>
        </div>

        <form id="form-enviar-mgs" action="">
            <input type="hidden" id="codigoMeta" type="text" name="codigoMeta" value="<%= request.getParameter("codigoMeta") %>">
            <input type="hidden" id="codigoTutoria" type="text" name="codigoTutoria" value="<%= request.getParameter("codigoTutoria") %>">
            <input id="form-text" type="text" placeholder="  Escreva sua mensagem" name="mensagemUsuario">
            <input id="form-button" type="" value="Enviar">
        </form>
    </div>


    <div id="div-area">
        <div id="div-area-footer1">
            <div id="div-area-image1">
                <img id="image-main-footer" src="imagens/mensagens/Frame 1.png" alt="">
            </div>
            <div id="div-area-image2">
                <a href=""><img src="imagens/mensagens/icons8-facebook-50 1.png" alt=""></a>
                <a href=""><img src="imagens/mensagens/icons8-instagram-64 1.png" alt=""></a>
                <a href=""><img src="imagens/mensagens/icons8-linkedin-50 1.png" alt=""></a>
            </div>
        </div>
        <div id="div-area-footer2">
            <strong>
                <p style="font-size: 1.3rem; height: 80%;">Informações:</p>
            </strong>
            <a href="">
                <p style="height: 10%; text-decoration: underline;">Sobre</p>
            </a>
            <a href="">
                <p style="height: 10%; text-decoration: underline;">Contato</p>
            </a>
        </div>
    </div>
    </div>
    <script src="scripts/edicaoMensagem/validarEdicaoMetas.js"></script>
    <script src="scripts/mensagens/editarmensagem.js" defer></script>
</body>

</html>