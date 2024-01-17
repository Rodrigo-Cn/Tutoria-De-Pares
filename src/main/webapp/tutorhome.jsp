<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Tutor" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.TutorDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="icon" href="imagens/cadastro/Frame1.png" type="image/png">
    <link rel="stylesheet" href="styles/tutorhome/tutor.css">
</head>
<body>
    <script src="scripts/tutorhome/barra-lateral.js"></script>
    <script src="scripts/tutorhome/menu-entrar-tutoria.js"></script>
    <script src="scripts/tutorhome/cards.js" defer></script>
    <script src="scripts/tutorhome/verificar-entrar-tutoria.js"></script>

    <div id="container">
        <div id="shadow-entrar-tutoria">
            <div id="div-entrar-tutoria">
                <div id="entrar-tutoria-exit">
                    <div id="entrar-tutoria-exit-space"></div>
                    <img id="entrar-tutoria-exit-image" src="imagens/tutorhome/icons8-fechar-janela-96.png" alt="">
                </div>
                <div id="painel-entrar-tutoria">
                    <div id="entrar-text">
                        <h1>Entrar em Tutoria</h1>
                    </div>
                    <div>
                        <form action="" id="form-entrar-tutoria">
                            <input type="text" name="" id="input1-entrar-tutoria" placeholder=" ID">
                            <input type="text" name="" id="input2-entrar-tutoria" placeholder=" Senha">
                            <input type="button" name="" id="input3-entrar-tutoria" value="Entrar">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="barra-ferramentas">
            <div id="shadow-zone"></div>
            <div id="nav-zone">
                <div id="nav-lateral-image"><a href=""><img src="imagens/tutorhome/icons8-usuario-homem-com-círculo-100.png" alt="icons8-usuario-homem-com-círculo-100.png"></a></div>
                <div id="nav-lateral-name"><a href=""><p><%= ((Tutor) request.getAttribute("tutor")).getNome() %></p></a></div>
                <div id="nav-lateral-option1"><a href="">Editar Perfil</a></div>
                <div id="nav-lateral-option3"><a href="main">Sair</a></div>
            </div>
        </div>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/tutorhome/Frame 1.png" id="navbar-image" alt="frame.png"></div>
                <div id="navbar-name"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio">
                    <img  id="navbar-image2" src="imagens/tutorhome/icons8-soma-96.png" alt="icons8-soma-384.png">
                    <img class="iniciar-barra" id="navbar-image3" src="imagens/tutorhome/icons8-usuario-96.png" alt="">
                    <h2 class="iniciar-barra2" id="navbar-name2"><%= ((Tutor) request.getAttribute("tutor")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <%
            Object tutoriasObject = request.getAttribute("tutorias");
            ArrayList<Tutoria> tutorias = null;

            if (tutoriasObject instanceof ArrayList) {
                tutorias = (ArrayList<Tutoria>) tutoriasObject;
            }
        %>

        <h1 id="section-titulo">Tutorias Cadastradas:</h1>
        <div id="container-slide">
            <% if (tutorias.size() >= 2) { %>
                <div id="arrow-left"><img src="imagens/tutorhome/icons8-arrow-100(1).png" alt="icons8-arrow-100(1).png" id="img-arrow-left"></div>
            <% } %>
            <div id="container-cards">
                  <%
                        if (tutorias.size() == 0) { %>
                              <div class="slider on">
                                    <img src="imagens/tutorhome/solar_pin-bold.png" alt="uiw_paper-clip.png" id="clip-card">
                                    <h1 id="titulo-card">Nenhuma Tutoria Cadastrada</h1>
                                    <hr>
                                    <h1 id="titulo-card-ator">(Torne-se um tutor)</h1>
                                    <hr>
                                    <hr style="margin-top: 6.7%;">
                              </div>
                           <% } else if (tutorias.size() == 1){ %>
                               <a href="tutoria?id=<%= tutorias.get(0).getCodigo() %>">
                                   <div class="slider on">
                                       <img src="imagens/tutorhome/solar_pin-bold.png" alt="uiw_paper-clip.png" id="clip-card">
                                       <h1 id="titulo-card"><%= tutorias.get(0).getDisciplina().getNome() %></h1>
                                       <hr>
                                       <h1 id="titulo-card-ator">Tutorado: <%= tutorias.get(0).getTutorado().getNome() %></h1>
                                       <hr>
                                       <hr style="margin-top: 6.7%;">
                                   </div>
                               </a>
                           <% } else { %>
                               <a href="tutoria?id=<%= tutorias.get(0).getCodigo() %>">
                                   <div class="slider on">
                                       <img src="imagens/tutorhome/solar_pin-bold.png" alt="uiw_paper-clip.png" id="clip-card">
                                       <h1 id="titulo-card"><%= tutorias.get(0).getDisciplina().getNome() %></h1>
                                       <hr>
                                       <h1 id="titulo-card-ator">Tutorado: <%= tutorias.get(0).getTutorado().getNome() %></h1>
                                       <hr>
                                       <hr style="margin-top: 6.7%;">
                                   </div>
                               </a>
                               <% for (int i = 1; i < tutorias.size(); i++) { %>
                                   <a href="tutoria?id=<%= tutorias.get(i).getCodigo() %>">
                                       <div class="slider">
                                           <img src="imagens/tutorhome/solar_pin-bold.png" alt="uiw_paper-clip.png" id="clip-card">
                                           <h1 id="titulo-card"><%= tutorias.get(i).getDisciplina().getNome() %></h1>
                                           <hr>
                                           <h1 id="titulo-card-ator">Tutorado: <%= tutorias.get(i).getTutorado().getNome() %></h1>
                                           <hr>
                                           <hr style="margin-top: 6.7%;">
                                       </div>
                                   </a>
                               <% } %>
                           <% } %>
            </div>
            <% if (tutorias.size() >= 2) { %>
                <div id="arrow-right"><img src="imagens/tutorhome/icons8-arrow-100.png" alt="icons8-arrow-100.png" id="img-arrow-right"></div>
            <% } %>
        </div>

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
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>

    <script src="scripts/tutorhome/menu-entrar-tutoria.js"></script>
    <script src="scripts/tutorhome/barra-lateral.js"></script>
    <script src="scripts/tutorhome/cards.js"></script>
    <script src="scripts/tutorhome/verificar-entrar-tutoria.js"></script>
</body>
</html>