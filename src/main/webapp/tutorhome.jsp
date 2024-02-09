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
    <link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
    <link rel="stylesheet" href="styles/tutorhome/tutor.css">
</head>
<body>
    <script src="scripts/tutorhome/barra-lateral.js"></script>
    <script src="scripts/tutorhome/menu-entrar-tutoria.js"></script>
    <script src="scripts/tutorhome/cards.js" defer></script>
    <script src="scripts/tutorhome/verificar-entrar-tutoria.js"></script>

    <div id="container">
        <div id="shadow-entrar-tutoria" class="blur-in">
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
                        <form action="loginTutoriaTutor" id="form-entrar-tutoria" name="form-entrar-tutoria">
                             <input type="hidden" name="id" id="input0-id-usuario" value="<%= request.getParameter("id") %>">
                             <input type="number" name="codigo" id="input1-entrar-tutoria" placeholder=" Código">
                             <input type="text" name="senha" id="input2-entrar-tutoria" placeholder=" Senha">
                              <div id="mensagemDeErro" style="color: red; margin-bottom: 50px; font-size: 20px;"></div>
                              <%
                               String mensagemErro = (String) request.getAttribute("mensagemErro");
                               if (mensagemErro != null) {
                               %>
                               <div style="color: red; margin-bottom: 10px; font-size: 18px;">
                               <%= mensagemErro %>
                               </div>
                                <%
                                }
                                %>
                                <input type="button" name="" id="input3-entrar-tutoria" value="Entrar" onclick="validarLoginTutoria()">
                                </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="barra-ferramentas" class="blur-in">
            <div id="shadow-zone"></div>
            <div id="nav-zone">
                <div id="nav-lateral-image"><a href=""><img src="imagens/tutorhome/icons8-usuario-homem-com-círculo-100.png" alt="icons8-usuario-homem-com-círculo-100.png"></a></div>
                <div id="nav-lateral-name"><a href=""><p><%= ((Tutor) request.getAttribute("tutor")).getNome() %></p></a></div>
                <div id="nav-lateral-option1"><a href="edicaoTutor?id=<%= request.getParameter("id")%>">Editar Perfil</a></div>
                <div id="nav-lateral-option3"><a href="main">Sair</a></div>
            </div>
        </div>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img  class="tracking-in-expand-forward-top" src="imagens/tutorhome/Frame 1.png" id="navbar-image" alt="frame.png"></div>
                <div id="navbar-name"><p class="tracking-in-expand-forward-top">Tutoria</p><p class="tracking-in-expand-forward-top">De</p><p class="tracking-in-expand-forward-top">Pares</p></div>
            </div>
                <div id="navbar-inicio">
                    <img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/tutorhome/icons8-soma-96.png" alt="icons8-soma-384.png">
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/tutorhome/icons8-usuario-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((Tutor) request.getAttribute("tutor")).getNome().split(" ")[0] %></h2>
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
                              <div class="slider on rotate-scale-down-horizontal">
                                    <h1 id="titulo-card">Nenhuma Tutoria Cadastrada</h1>
                                    <hr>
                                    <h1 id="titulo-card-ator">(Torne-se um tutor)</h1>
                                    <hr>
                                    <hr style="margin-top: 6.7%;">
                              </div>
                           <% } else if (tutorias.size() == 1){ %>
                               <a href="entrarTutoriaTutor?codigo=<%= tutorias.get(0).getCodigo() %>&id=<%= request.getParameter("id") %>">
                                   <div class="slider on rotate-scale-down-horizontal">
                                       <h1 id="titulo-card"><%= tutorias.get(0).getDisciplina() != null ? tutorias.get(0).getDisciplina().getNome() : "Disciplina não disponível" %></h1>
                                       <hr>
                                       <h1 id="titulo-card-ator">Tutorado: <%= tutorias.get(0).getTutorado() != null ? tutorias.get(0).getTutorado().getNome() : "Tutorado não cadastrado" %></h1>
                                       <hr>
                                       <hr style="margin-top: 6.7%;">
                                   </div>
                               </a>
                           <% } else { %>
                               <a href="entrarTutoriaTutor?codigo=<%= tutorias.get(0).getCodigo() %>&id=<%= request.getParameter("id") %>">
                                   <div class="slider on rotate-scale-down-horizontal">
                                       <h1 id="titulo-card"><%= tutorias.get(0).getDisciplina().getNome() %></h1>
                                       <hr>
                                       <h1 id="titulo-card-ator">Tutorado: <%= tutorias.get(0).getTutorado() != null ? tutorias.get(0).getTutorado().getNome() : "Tutorado não cadastrado" %></h1>
                                       <hr>
                                       <hr style="margin-top: 6.7%;">
                                   </div>
                               </a>
                               <% for (int i = 1; i < tutorias.size(); i++) { %>
                                   <a href="entrarTutoriaTutor?codigo=<%= tutorias.get(i).getCodigo() %>&id=<%= request.getParameter("id") %>">
                                       <div class="slider rotate-scale-down-horizontal">
                                           <h1 id="titulo-card"><%= tutorias.get(i).getDisciplina().getNome() %></h1>
                                           <hr>
                                           <h1 id="titulo-card-ator">Tutorado:  <%= tutorias.get(i).getTutorado() != null ? tutorias.get(i).getTutorado().getNome() : "Tutorado não cadastrado" %></h1>
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
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>

    <script src="scripts/loginTutoria/loginTutoriaValidador.js" ></script>
    <script src="scripts/tutorhome/menu-entrar-tutoria.js"></script>
    <script src="scripts/tutorhome/barra-lateral.js"></script>
    <script src="scripts/tutorhome/cards.js"></script>
    <script src="scripts/tutorhome/verificar-entrar-tutoria.js"></script>
</body>
</html>