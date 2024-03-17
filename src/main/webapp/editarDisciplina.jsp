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
    <title>Editar Disciplina</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/editarDisciplina/editarDisciplina.css">
<body>
<div vw class="enabled">
    <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
        <div class="vw-plugin-top-wrapper"></div>
    </div>
</div>
<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
</script>
    <script src="scripts/editarDisciplina/validarDisciplina.js"></script>
        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/editarDisciplina/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="menudisciplinas" style="margin-top: 3.4%;"><img  id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/editarDisciplina/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/editarDisciplina/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((RepresentanteNapne) request.getAttribute("representante")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <div id="section">
            <form action="editandoDisciplina" name="editar-disciplina" method="post" id="section-editar">
                <div id="section-titulo"><img id="image" src="imagens/editarDisciplina/apagador-de-quadro.png" alt="">Editar Disciplina</div>
                <div id="section-codigo"><label for="codigo-disciplina">Código Disciplina:</label><input id="codigo" name="codigo-disciplina" type="number" value="<%= ((Disciplina) request.getAttribute("disciplina")).getCodigo() %>" readonly></div>
                <div id="section-nome"><label for="nome-disciplina">Nome/Semestre:</label><input id="nome" name="nome-disciplina" type="text" value="<%= ((Disciplina) request.getAttribute("disciplina")).getNome() %>" ></div>
                <div id="section-professor"><label for="id-professor">Id do Professor:</label><input name="id-professor" id="professor" name="id-professor" type="number" value="<%= ((Disciplina) request.getAttribute("disciplina")).getProfessor().getId() %>"></div>
                <div id="section-botao"><input id="botao" type="button" value="Atualizar"></div>
            </form>
        </div>


        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/editarDisciplina/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/editarDisciplina/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/editarDisciplina/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/editarDisciplina/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>   
    <script src="scripts/editarDisciplina/validarDisciplina.js"></script>
</body>
</html>