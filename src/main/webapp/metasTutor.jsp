<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Tutor" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.model.Meta" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/metas/metas.css">
    <script src="scripts/metas/confirmador.js" defer></script>
    <title>Menu de Metas</title>
</head>
<body>
    <script src="scripts/meta/editarmeta.js" defer></script>
    <script src="scripts/meta/criarmeta.js" defer></script>


        <div id="navbar">
            <div id="navbar-logo">
                <div><a href="voltarParaMainTutor?id=<%= request.getParameter("id")%>"><img src="imagens/metas/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio">
                    <a href="voltarParaMainTutor?id=<%= request.getParameter("id") %>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/metas/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/metas/usua.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((Tutor) request.getAttribute("tutor")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="section">
            <div id="section-title">
                <img src="imagens/metas/icons8-goals-64.png" alt="">
                <h1>Metas</h1>
            </div>

            <div id="section-cards">

                        <% if(((Tutoria) request.getAttribute("tutoria")).getMetas().size() == 0) { %>

                         <div class="card">
                              <div class="card-title">
                              <span class="titulo"> &bull; Cadastre uma meta! </span>
                              <hr width="100%">
                              </div>
                              <div class="card-icones">
                                    <a href="" style="font-size: 1.3rem;"><img class="icone-card" src="imagens/metas/icons8-bate-papo-cheio-96.png" alt=""> 0 </a>
                                </div>
                             </div>

                        <% } else { %>

                            <% for(int i=0; i<((Tutoria) request.getAttribute("tutoria")).getMetas().size(); i++) {%>

                                <div class="card">
                                <div class="card-title">
                                <span class="titulo"> &bull; <%= ((Tutoria) request.getAttribute("tutoria")).getMetas().get(i).getTitulo() %> </span>
                                <hr width="100%">
                                </div>
                                    <div class="card-icones">
                                     <a href="carregarMensagensTutor?codigoMeta=<%=((Tutoria) request.getAttribute("tutoria")).getMetas().get(i).getCodigo()%>&codigoTutoria=<%=((Tutoria) request.getAttribute("tutoria")).getCodigo()%>&id=<%= ((Tutor) request.getAttribute("tutor")).getId() %>" style="font-size: 1.3rem; margin-right: 12%;"><img class="icone-card" src="imagens/metas/icons8-bate-papo-cheio-96.png" alt=""> <%= ((Tutoria) request.getAttribute("tutoria")).getMetas().get(i).getMensagens().size() %> </a>
                                   </div>
                                </div>

                            <%}%>

                        <% } %>

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

    <script src="scripts/metas/confirmador.js" defer></script>
    <script src="scripts/metas/criarmeta.js" defer></script>
    <script src="scripts/metas/verificaSeCriarMetaNulo.js"></script>
</body>
</html>