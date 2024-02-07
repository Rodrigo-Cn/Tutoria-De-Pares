<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.dao.TutoriaDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Tutorias</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/buscarTutoria/buscarTutoria.css">
<body>
    <script src="scripts/buscarTutoria/paginacao.js"></script>
    <script src="https://unpkg.com/smoothscroll-polyfill@0.6.1/dist/smoothscroll.min.js"></script>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/buscarTutoria/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="napnehome?id=<%= request.getAttribute("id") %>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/buscarTutoria/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/buscarTutoria/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>
        <%
                Object tutoriasObject = request.getAttribute("tutorias");
                ArrayList<Tutoria> tutorias = null;

                if (tutoriasObject instanceof ArrayList) {
                    tutorias = (ArrayList<Tutoria>) tutoriasObject;
                }
        %>
        <div id="div-section">
            <div id="div-titulo-section">
                <h1 id="titulo-section">Resultados para "<%= request.getAttribute("buscar") %>"</h1>
                <% if (tutorias.size() > 0) { %>
                    <h4 id="titulo-section2"><%= tutorias.size() %> tutorias encontradas</h4>
                <% } %>
            </div>
            <div>

            </div>
            <div id="div-cards-section"></div>

                <% if (tutorias != null && tutorias.size() > 0) { %>
                    <% for (int i = 0; i < tutorias.size(); i++) { %>
                        <div class="card">
                            <a href=""><h1 id="card-titulo"><%= tutorias.get(i).getDisciplina().getNome() %></h1></a>
                            <h4 class="card-section">Tutor:  <%= tutorias.get(i).getTutor() != null ? tutorias.get(i).getTutor().getNome() : "Tutor não cadastrado" %></h4>
                            <h4 class="card-section">Tutorado: <%= tutorias.get(i).getTutorado() != null ? tutorias.get(i).getTutorado().getNome() : "Tutorado não cadastrado" %></h4>
                        </div>
                    <% } %>
                <% } else{%>
                    <img src="imagens/buscarTutoria/icons8-nada-encontrado-96.png" alt="">
                    <p style="font-size:2.5rem;">Nenhuma Tutoria Encontrada</p>
                    <p style="font-size:1.5rem; margin-bottom:18rem;color:gray;">Tente um nome diferente</p>
                <% } %>

            </div>
            <div id="paginacao">
                <img id="seta-esquerda" src="imagens/buscarTutoria/seta-esquerda.png" alt="">
                <div id="paginacao-num">1...</div>
                <% if (tutorias.size() > 4) { %>
                    <img id="seta-direita" src="imagens/buscarTutoria/seta-direita.png" alt="">
                <% } %>
            </div>
        </div>

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/buscarTutoria/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/buscarTutoria/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/buscarTutoria/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/buscarTutoria/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>
    <script src="scripts/buscarTutoria/paginacao.js"></script>
    <script src="https://unpkg.com/smoothscroll-polyfill@0.6.1/dist/smoothscroll.min.js"></script>
</body>
</html>