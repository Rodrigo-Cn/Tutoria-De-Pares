<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Tutorado" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.TutoradoDao" %>
<%@ page import="main.model.RepresentanteNapne" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Profissional</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/cadastrarNapne/cadastrar-napne.css">
<body>
    <script src="scripts/cadastrarNapne/validar-cadastro.js"></script>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/cadastrarNapne/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="napnehome?id=<%= request.getAttribute("id") %>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/cadastrarNapne/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/cadastrarNapne/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="container-slide">
            <div id="image-section-div">
                <img id="image-section" src="imagens/cadastrarNapne/pexels-fauxels-3183197.jpg" alt="">
            </div>
            <div id="card-section">
                <img id="card-section-image" src="imagens/cadastrarNapne/icons8-profissional-100(1).png" alt="">
                <div id="text-section"><strong>Cadastrar Representante NAPNE</strong></div>
                <form action="cadastrarnapne" id="form-section" name="cadastrar-profissional">
                    <div id="div-text-input" style="display: none;">
                        <input type="number" name="id" value="<%= request.getAttribute("id") %>">
                    </div>
                    <div id="div-text-input">
                        <input type="text" name="nome" class="input-section" placeholder="  Nome">
                    </div>
                    <div id="div-text-input">
                        <input type="email" name="email" class="input-section" placeholder="  E-mail">
                    </div>
                    <div id="div-text-input">
                        <input type="password" name="senha1" class="input-section" placeholder="  Senha">
                    </div>
                    <div id="div-text-input">
                        <input type="password" name="senha2" class="input-section" placeholder="  Confirmar Senha">
                    </div>
                    <div id="section-mensagem"></div>
                    <div id="buttons-section">
                        <input type="button" value="Cadastrar" id="buscar-section">
                    </div>
                </form>
            </div>
        </div>  

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/cadastrarNapne/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/cadastrarNapne/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/cadastrarNapne/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/cadastrarNapne/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>   
    <script src="scripts/cadastrarNapne/validar-cadastro.js"></script>
</body>
</html>