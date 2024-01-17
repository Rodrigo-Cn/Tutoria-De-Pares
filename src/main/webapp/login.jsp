<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="imagens/cadastro/Frame1.png" type="image/png">
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
<div class="container">
    <nav>
        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/login/Frame 1.png" id="navbar-image" alt="frame.png"></div>
                <div id="navbar-name"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
            <a href="main" id="navbar-a">
                <div id="navbar-inicio">
                    <img id="navbar-image2" src="imagens/login/icons8-casa-384 1.png" alt="icons8-casa-384.png">
                    <p id="navbar-name2">IN&Iacute;CIO</p>
                </div>
            </a>
        </div>
    </nav>
    <section>
        <div class="section">
            <div id="section-image">
                <img id="img-section" src="imagens/login/estudantes-universitarios-lotando-ao-ar-livre 1(1).png" alt="estudantes-universitarios-lotando-ao-ar-livre.png">
            </div>
            <div class="section-login">
                <h2 id="text-section">Fa&ccedil;a seu login</h2>
                <form action="login" id="form-section" name="login">
                    <input type="text" id="input-text1" placeholder="   Email" name="email">
                    <img src="imagens/login/olho(1).png" alt="" id="img-password">
                    <input type="password" id="input-text2" placeholder="   Senha" name="senha">
                    <p id="entrada1"></p>
                    <input type="submit" value="Entrar" id="input-button1">
                </form>
            </div>
            <%
                String erroLogin = (String) request.getAttribute("erroLogin");
                if (erroLogin != null) {
            %>
                <div class="alert alert-danger">
                    <%= erroLogin %>
                </div>
            <%
                }
            %>
        </div>
    </section>
</div>
<script src="scripts/loginValidador.js"></script>
</body>
</html>