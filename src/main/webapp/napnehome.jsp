<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.RepresentanteNapne" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.dao.RepresentanteNapneDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/napnehome/napne.css">
<body>
    <script src="scripts/napnehome/barra-lateral.js"></script>
    <script src="scripts/napnehome/buscar-tutoria.js"></script>

    <div id="container">
        <div id="barra-ferramentas" class="blur-in">
            <div id="shadow-zone"></div>
            <div id="nav-zone">
                <div id="nav-lateral-image"><a href=""><img src="imagens/napnehome/icons8-usuário-homem-com-círculo-100.png" alt="icons8-usuário-homem-com-círculo-100.png"></a></div>
                <div id="nav-lateral-name"><a href=""><p><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome() %></p></a></div>
                <div id="nav-lateral-option1"><a href="">Editar Perfil</a></div>
                <div id="nav-lateral-option2"><a href="">Nova Tutoria</a></div>
                <div id="nav-lateral-option2"><a href="telacadastronapne?id=<%= ((RepresentanteNapne) request.getAttribute("representante")).getId() %>">Cadastrar Profissional</a></div>
                <div id="nav-lateral-option2"><a href="">Menu de Disciplinas</a></div>
                <div id="nav-lateral-option3"><a href="main">Sair</a></div>
            </div>
        </div>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/napnehome/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/napnehome/icons8-soma-96.png" alt="icons8-casa-384.png">
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/napnehome/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="container-slide">
            <div id="card-section">
                <div id="text-section">Buscar Tutorias</div>
                <hr id="linha-section">
                <form action="buscartutoria" id="form-section" name="busca">
                    <div id="div-text-input">
                        <input type="number" name="id" style="Display:none;" value="<%= ((RepresentanteNapne) request.getAttribute("representante")).getId() %>">
                        <input type="text" name="buscar" id="input-section" placeholder="   Digite aqui o que deseja buscar">
                        <img src="imagens/napnehome/icons8-lupa-250(1).png" alt="" id="lupa-section" class="rotate-center">
                    </div>
                    <div id="buttons-section">
                        <select name="select" id="select-section">
                            <option value="todos">Filtrar por:</option>
                            <option value="matricula-tutor">Matrícula do Tutor</option>
                            <option value="matricula-tutorado">Matrícula do Tutorado</option>
                            <option value="nome-tutor">Nome do Tutor</option>
                            <option value="nome-tutorado">Nome do Tutorado</option>
                            <option value="nome-disciplina">Nome da Disciplina</option>
                        </select>
                        <input type="button" value="Buscar" id="buscar-section">
                    </div>
                </form>
            </div>
        </div>  

        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/napnehome/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/napnehome/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/napnehome/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/napnehome/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>   
    <script src="scripts/napnehome/barra-lateral.js"></script>
    <script src="scripts/napnehome/buscar-tutoria.js"></script>
</body>
</html>