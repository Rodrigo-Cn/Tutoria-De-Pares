<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.RepresentanteNapneDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Disciplinas</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/menuDisciplinas/menuDisciplina.css">
<body>
    <script src="scripts/menuDisciplinas/criar-disciplina.js" defer></script>
    <script src="scripts/menuDisciplinas/buscar-disciplina.js"></script>

        <div id="nav-shadow" class="blur-in">
            <form action="criardisciplina" id="sec-entrar-tutoria" name="criar-disciplina">
                <div id="sec-entrar-image"><img id="sec-image" src="imagens/menuDisciplinas/1486564399-close_81512.png" alt="1486564399-close_81512.png"></div>
                <div id="sec-entrar-input1"><input id="sec-input1" name="codigo-professor" type="number" placeholder="Código Professor"></div>
                <div id="sec-entrar-input2"><input id="sec-input2" name="nome-disciplina" type="text" placeholder="Disciplina - Semestre"></div>
                <div id="sec-entrar-input3"></div>
                <div id="sec-entrar-button"><input id="sec-button" type="button" value="Criar"></div>
            </form>
        </div>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/menuDisciplinas/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="napnehome?id=<%= ((RepresentanteNapne) request.getAttribute("representante")).getId() %>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/cadastrarNapne/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/cadastrarNapne/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="div-section">
            <form action="buscardisciplina" id="div-section-nav" name="buscar-disciplina">
                <div id="div-section-image"><img id="img-menu" src="imagens/menuDisciplinas/educacao.png" alt="">Menu de Disciplinas</div>
                <div id="div-section-text"><input id="section-text" name="disciplina-buscar" type="text" placeholder="  Nome da Disciplina"></div>
                <div id="div-section-button"><input id="section-button" type="button" value="Buscar"><img id="section-image" src="imagens/menuDisciplinas/adicionar-botao.png" alt=""></div>
            </form>
        </div>

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/menuDisciplinas/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/menuDisciplinas/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/menuDisciplinas/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/menuDisciplinas/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>
        <%
            String mensagemErro = (String) request.getAttribute("mensagemErro");
            if (mensagemErro != null && !mensagemErro.isEmpty()) {
        %>
                <script type="text/javascript">
                    alert("<%= mensagemErro %>");
                </script>
        <%
            }
        %>
    <script src="scripts/menuDisciplinas/criar-disciplina.js"></script>
    <script src="scripts/menuDisciplinas/buscar-disciplina.js"></script>
</body>
</html>