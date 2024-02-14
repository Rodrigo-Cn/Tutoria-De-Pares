<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.model.Metas" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/metas/metas.css">
    <title>Menu de Metas</title>
</head>
<body>
    <script src="scripts/meta/editarmeta.js" defer></script>
    <script src="scripts/meta/criarmeta.js" defer></script>
    <%
    Metas metas = (Metas) request.getAttribute("metas");
    %>
    <div id="corpo-editar-meta" style="display: flex">
        <form class="editar-meta" action="editarMetaNapne" id="editarMeta" onsubmit="return validarFormulario()">
            <div class="titulo-editar-meta"><div class="titulo-editar">Editar Nome</div> <a href="carregarMetasNapne?id=<%=((RepresentanteNapne) request.getAttribute("representante")).getId()%>&codigo=<%=((Tutoria) request.getAttribute("tutoria")).getCodigo()%>"> <img id="fechar-editar-meta" src="imagens/metas/icons8-fechar-janela-48.png" alt=""> </a> </div>
             <%
               if (metas != null) { %>
               <input name="nome-criar" class="text-editar-meta" type="text" value="<%= metas.getTitulo() %>">
             <% } %>
            <input type="hidden" name="codigo" value="<%= ((Tutoria) request.getAttribute("tutoria")).getCodigo() %>" id="codigo">
            <input type="hidden" name="codigoMeta" value="<%= request.getParameter("codigoMeta")%>" id="codigoMeta">
            <h3 id="mensagemErro" style="color: red"></h3>
            <input class="button-editar-meta" type="submit" value="Confirmar">
        </form>
    </div>

        <div id="navbar">
            <div id="navbar-logo">
                <div><a href=""><img src="imagens/metas/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio">
                    <a href="" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/metas/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/metas/usua.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="section">
            <div id="section-title">
                <img src="imagens/metas/icons8-goals-64.png" alt="">
                <h1>Metas</h1>
            </div>
            <div id="criar-meta">
                <a href=""><input id="button-section" type="button" value="Criar uma Meta"></a>
            </div>
            <div id="section-cards">


                <% for(int i=0; i<((Tutoria) request.getAttribute("tutoria")).getMetas().size(); i++) {%>

                    <div class="card">
                    <div class="card-title">
                    <span class="titulo"> &bull; <%= ((Tutoria) request.getAttribute("tutoria")).getMetas().get(i).getTitulo() %> </span>
                    <hr width="100%">
                    </div>
                        <div class="card-icones">
                         <a href="" style="font-size: 1.3rem; margin-right: 12%;"><img class="icone-card" src="imagens/metas/icons8-bate-papo-cheio-96.png" alt=""> <%= ((Tutoria) request.getAttribute("tutoria")).getMetas().get(i).getMensagens().size() %> </a>
                         <a class="editar" href="" style="font-size: 1.3rem; margin-right: 12%;"><img class="icone-card" src="imagens/metas/configu.png" alt=""></a>
                         <a href=""><img class="icone-card" src="imagens/metas/icons8-lixo-100.png" alt=""></a>
                       </div>
                    </div>

                <%}%>
            </div>

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/metas/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/metas/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/metas/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/metas/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>

    <script src="scripts/edicaoMetas/validadorEdicaoMetas.js"></script>
    <script src="scripts/metas/criarmeta.js" defer></script>
    <script src="scripts/metas/confirmador.js" defer></script>
    <script src="scripts/metas/verificaSeCriarMetaNulo.js"></script>
</body>
</html>