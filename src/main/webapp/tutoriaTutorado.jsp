<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Professor" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.model.Tutor" %>
<%@ page import="main.model.Tutorado" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.TutoradoDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu de Tutoria</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/tutoriaGenerico/tutoria.css">
<body>
        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/tutoriaGenerico/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="tutoradohome?id=<%= ((Tutorado) request.getAttribute("tutorado")).getId() %>" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/tutoriaGenerico/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/tutoriaGenerico/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((Tutorado) request.getAttribute("tutorado")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="section">
            <div id="section-menu">
                <img id="section-menu-img" src="imagens/tutoriaGenerico/tutoria.jpg" alt="">
            </div>
            <div id="section-dados">
                <div id="section-titulo"><h1>Menu de Tutoria</h1></div>
                <div id="section-codigo-senha"><div id="section-codigo">Código: <%= ((Tutoria) request.getAttribute("tutoria")).getCodigo() %></div><div id="section-senha">Senha: <%= ((Tutoria) request.getAttribute("tutoria")).getSenha() %></div></div>
                <div class="section-dados"><%= ((Tutoria) request.getAttribute("tutoria")).getDisciplina().getNome() %></div>
                <div class="section-dados">Professor: <%= ((Tutoria) request.getAttribute("tutoria")).getDisciplina().getProfessor().getNome() != null ? ((Tutoria) request.getAttribute("tutoria")).getDisciplina().getProfessor().getNome() : "Professor Não Cadastrado" %></div>
                <div class="section-dados">
                  Tutor: <%
                    if (((Tutoria) request.getAttribute("tutoria")).getTutor() != null) {
                      out.print(((Tutoria) request.getAttribute("tutoria")).getTutor().getNome());
                    } else {
                      out.print("Não Cadastrado");
                    }
                  %>
                </div>
                <div class="section-dados">Tutorado: <%= ((Tutoria) request.getAttribute("tutoria")).getTutorado().getNome() != null ? ((Tutoria) request.getAttribute("tutoria")).getTutorado().getNome() : "Não Cadastrado" %></div>
                <div id="section-buttons"><a href=""><input class="buttons" type="button" value="Metas"></a><a href=""><input class="buttons" type="button" value="Atendimentos"></a></div>          
            </div>
        </div>

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/tutoriaGenerico/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/tutoriaGenerico/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/tutoriaGenerico/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/tutoriaGenerico/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>
</body>
</html>