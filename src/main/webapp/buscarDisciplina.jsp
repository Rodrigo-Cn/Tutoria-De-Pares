<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="main.model.Disciplina" %>
<%@ page import="main.dao.DisciplinaDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Disciplinas</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/buscarDisciplina/buscarDisciplina.css">
<body>
    <script src="scripts/buscarDisciplina/paginacao.js"></script>
    <script src="scripts/buscarDisciplina/excluir.js"></script>
    <script src="https://unpkg.com/smoothscroll-polyfill@0.6.1/dist/smoothscroll.min.js"></script>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/buscarDisciplinas/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/buscarDisciplinas/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/buscarDisciplinas/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>
        <%
                Object disciplinasObject = request.getAttribute("disciplinas");
                ArrayList<Disciplina> disciplinas = null;

                if (disciplinasObject instanceof ArrayList) {
                    disciplinas = (ArrayList<Disciplina>) disciplinasObject;
                }
        %>
        <div id="div-section">
            <div id="div-titulo-section">
                <h1 id="titulo-section">Resultados para "<%= request.getAttribute("buscar") %>"</h1>
                <% if (disciplinas.size() > 0) { %>
                    <h4 id="titulo-section2"><%= disciplinas.size() %> disciplinas encontradas</h4>
                <% } %>
            </div>
            <div id="div-cards-section"></div>

                <% if (disciplinas != null && disciplinas.size() > 0) { %>
                    <% for (int i = 0; i < disciplinas.size(); i++) { %>
                        <div class="card">
                            <a href=""><h1 id="card-titulo"><%= disciplinas.get(i).getNome() %></h1></a>
                            <% if (disciplinas.get(i).getProfessor().getNome() != null) { %>
                                <h4 class="card-section">Professor: <%= disciplinas.get(i).getProfessor().getNome() %></h4>
                            <% } else{%>
                                <h4 class="card-section">Professor não cadastrado</h4>
                            <% } %>
                            <h4 class="card-section"><a href="" style="color: blue;">Editar</a><a href="javascript: confirmar(<%= disciplinas.get(i).getCodigo() %>)" style="color: red; margin-left: 4%;">Excluir</a></h4>
                        </div>
                    <% } %>
                <% } else{%>
                    <img src="imagens/buscarDisciplinas/icons8-nada-encontrado-96.png" alt="">
                    <p style="font-size:2.5rem;">Nenhuma Tutoria Encontrada</p>
                    <p style="font-size:1.5rem; margin-bottom:18rem;color:gray;">Tente um nome diferente</p>
                <% } %>


            </div>
            <div id="paginacao">
                <img id="seta-esquerda" src="imagens/buscarDisciplinas/seta-esquerda.png" alt="">
                <div id="paginacao-num">1...</div>
                <% if (disciplinas.size() > 4) { %>
                    <img id="seta-direita" src="imagens/buscarDisciplinas/seta-direita.png" alt="">
                <% } %>
            </div>
        </div>

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/buscarDisciplinas/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/buscarDisciplinas/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/buscarDisciplinas/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/buscarDisciplinas/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>
    <script src="scripts/buscarDisciplina/paginacao.js"></script>
    <script src="scripts/buscarDisciplina/excluir.js"></script>
    <script src="https://unpkg.com/smoothscroll-polyfill@0.6.1/dist/smoothscroll.min.js"></script>
</body>
</html>