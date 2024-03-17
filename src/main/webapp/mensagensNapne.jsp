<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
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
    <div id="body-editar-mensagem" class="body-editar-mensagem">
        <form id="editar-mensagem">
            <div id="editar-mensagem-title">
                <div style="width: 90%;">
                    <h2 style="margin-left: 34%;">Editar Mensagem</h2>
                </div><a href=""><img src="imagens/mensagens/icons8-fechar-janela-48.png" alt=""></a>
            </div>
            <input type="text" name="" id="input-editar-msg">
            <input type="button" value="Editar" id="button-editar-msg">
        </form>
    </div>

       <div id="corpo-deletar-meta" class="corpo-deletar-meta">
                <div class="editar-meta">
                 <div class="titulo-editar-meta"><div class="titulo-editar">Confirmar a exclusão?</div><img style="cursor: pointer;" id="fechar-deletar-meta" src="imagens/metas/icons8-fechar-janela-48.png" alt=""></div>
                 <input class="button-editar-meta" type="button" value="Sim" id="sim">
                </div>
         </div>

    <div id="navbar">
        <div id="navbar-logo">
            <div> <a href="voltarParaMainNapne?id=<%= request.getParameter("id")%>"> <img src="imagens/mensagens/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div> </a>
            <div id="navbar-name" class="tracking-in-expand-forward-top">
                <p>Tutoria</p>
                <p>De</p>
                <p>Pares</p>
            </div>
        </div> </a>
        <div id="navbar-inicio">
            <a href="voltarParaMainNapne?id=<%= request.getParameter("id")%>" style="margin-top: 3.4%;"><img id="navbar-image2" class="tracking-in-expand-forward-top"
                    src="imagens/mensagens/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
            <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3"
                src="imagens/mensagens/usu96.png" alt="">
            <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
        </div>
    </div>

    <div id="section">
        <div id="section-title">
            <h1>Meta: <%= ((Meta) request.getAttribute("meta")).getTitulo() %> </h1>
        </div>
        <div id="section-card">

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
                                   <a href="selecionaMensagemNapne?codigoMeta=<%=((Meta) request.getAttribute("meta")).getCodigo()%>&codigoTutoria=<%=((Tutoria) request.getAttribute("tutoria")).getCodigo()%>&id=<%= ((RepresentanteNapne) request.getAttribute("representante")).getId() %>&codigoMensagem=<%=((Meta) request.getAttribute("meta")).getMensagens().get(i).getCodigoMensagem()%>"><img id="iniciar-config" class="iniciar-config" src="imagens/mensagens/config.png" alt=""></a>
                                   <a onclick="confirmar(<%= ((Meta) request.getAttribute("meta")).getCodigo() %>, <%=((Tutoria) request.getAttribute("tutoria")).getCodigo()%>, <%=((RepresentanteNapne) request.getAttribute("representante")).getId()%>, <%= ((Meta) request.getAttribute("meta")).getMensagens().get(i).getCodigoMensagem()%>)"><img src="imagens/mensagens/icons8-lixo-50.png" alt=""></a>
                              </div>
                         </div>
                         <div class="body-card">
                              <%= ((Meta) request.getAttribute("meta")).getMensagens().get(i).getMsg() %>
                         </div>
                    </div>
                <% } %>

            <% } %>
        </div>

        <form id="form-enviar-mgs" action="enviarMensagemNapne">
            <input type="hidden" id="codigoMeta" type="text" name="codigoMeta" value="<%= request.getParameter("codigoMeta") %>">
            <input type="hidden" id="codigoTutoria" type="text" name="codigoTutoria" value="<%= request.getParameter("codigoTutoria") %>">
            <input id="form-text" type="text" placeholder="  Escreva sua mensagem" name="mensagemUsuario">
            <input id="form-button" type="submit" value="Enviar">
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

    <script src="scripts/mensagens/apagarmensagem.js"></script>
</body>
</html>