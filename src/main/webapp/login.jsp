<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="imagens/cadastro/Frame1.png" type="image/png">
    <link rel="stylesheet" href="styles/login/login.css">
</head>
<body>
<script src="scripts/login/loginValidador.js"></script>
<div class="container">
    <nav>
        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/login/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
            <a href="main" id="navbar-a">
                <div id="navbar-inicio">
                    <img id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/login/icons8-casa-384 1.png" alt="icons8-casa-384.png">
                    <p id="navbar-name2"  class="tracking-in-expand-forward-top" >IN&Iacute;CIO</p>
                </div>
            </a>
        </div>
    </nav>
    <section>
        <div class="section">
            <div id="section-image">
                <img id="img-section" class="tracking-in-expand" src="imagens/login/section.png" alt="estudantes-universitarios-lotando-ao-ar-livre.png">
            </div>
            <div class="section-login">
                <h2 id="text-section">Fa&ccedil;a seu login</h2>
                <form action="login" method="post" id="form-section" name="login">
                    <input type="text" id="input-text1" placeholder="   Email" name="email">
                    <img src="imagens/login/olho(1).png" alt="" id="img-password">
                    <input type="password" id="input-text2" placeholder="   Senha" name="senha">
                     <%
                                    String erroLogin = (String) request.getAttribute("erroLogin");
                                    if (erroLogin != null) {
                                %>
                                    <p id="entrada1">
                                        <%= erroLogin %>
                                    </p>
                                <%
                                    }
                                %>

                    <input type="submit" value="Entrar" id="input-button1">
                </form>
            </div>

        </div>
    </section>
    <div id="div-area">
        <div id="div-area-footer1">
            <div id="div-area-image1">
                <img id="image-main-footer" src="imagens/tutorhome/Frame 1.png" alt="">
            </div>
            <div id="div-area-image2">
                <a href=""><img src="imagens/tutorhome/icons8-facebook-50 1.png" alt=""></a>
                <a href=""><img src="imagens/tutorhome/icons8-instagram-64 1.png" alt=""></a>
                <a href=""><img src="imagens/tutorhome/icons8-linkedin-50 1.png" alt=""></a>
            </div>
        </div>
        <div id="div-area-footer2">
            <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
            <a href="sobre.html" target="_blank" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
            <a href="sobre.html" target="_blank" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
        </div>
    </div>
</div>
<script src="scripts/login/loginValidador.js"></script>
</body>
</html>