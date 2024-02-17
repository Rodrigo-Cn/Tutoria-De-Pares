<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.model.Tutorado" %>
<%@ page import="main.model.Tutoria" %>
<%@ page import="main.dao.TutoriaDao" %>
<%@ page import="main.model.Atendimento" %>
<%@ page import="main.dao.AtendimentoDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu de Atendimento</title>
</head>
<link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
<link rel="stylesheet" href="styles/atendimentoAdm/atendimento.css">
<body>

        <div id="navbar">
            <div id="navbar-logo">
                <div><img src="imagens/atendimentoAdm/Frame 1.png" id="navbar-image" class="tracking-in-expand-forward-top" alt="frame.png"></div>
                <div id="navbar-name" class="tracking-in-expand-forward-top"><p>Tutoria</p><p>De</p><p>Pares</p></div>
            </div>
                <div id="navbar-inicio"> 
                    <a href="entrarTutoriaTutorado?codigo=<%= request.getAttribute("codigo") %>" style="margin-top: 3.4%;"><img id="navbar-image2" class="tracking-in-expand-forward-top" src="imagens/atendimentoAdm/icons8-voltar-67.png" alt="icons8-casa-384.png"></a>
                    <img class="iniciar-barra tracking-in-expand-forward-top" id="navbar-image3" src="imagens/atendimentoAdm/icons8-usuário-96.png" alt="">
                    <h2 class="iniciar-barra2 tracking-in-expand-forward-top" id="navbar-name2"><%= ((Tutorado) request.getAttribute("tutorado")).getNome().split(" ")[0] %></h2>
                </div>
        </div>

        <%
            ArrayList<Atendimento> atendimentos = null;
            Object atendimentoObject = request.getAttribute("atendimentos");

            if (atendimentoObject instanceof ArrayList) {
                atendimentos = (ArrayList<Atendimento>) atendimentoObject;
            }
        %>

        <div id="section">
            <div id="title-section">
                <img id="title-section-image" src="imagens/atendimentoAdm/icons8-atendimento-100.png" alt="atendimento-100.png">Atendimentos
            </div>
            <div id="section-cards">
            <% if (atendimentos.size() == 0) { %>
                <div class="card">
                    <div class="card-section">
                           <div>Nenhum</div>
                           <div>Atendimento</div>
                           <div>Cadastrado !</div>
                    </div>
                </div>
            <% } else { %>
                <% for(int i=0; i<atendimentos.size(); i++){ %>
                <div class="card">
                    <div class="card-title">
                        <div class="card-title1">• <%= atendimentos.get(i).getConteudo() %></div>
                        <div class="card-title2"></div>
                    </div>
                    <div class="card-section">
                           <div>Data: <%= atendimentos.get(i).getData() %></div>
                           <div>Horário: <%= atendimentos.get(i).getHorario() %></div>
                           <div>Local: <%= atendimentos.get(i).getLocal() %></div>
                           <div>Carga Horária: <%= atendimentos.get(i).getCargaHoraria() %></div>
                    </div>
                </div>
                <% } %>
            <% } %>
            </div>

        </div>


        <div id="div-area">
            <div id="div-area-footer1">
                <div id="div-area-image1">
                    <img id="image-main-footer" src="imagens/atendimentoAdm/Frame 1.png" alt="">
                </div>
                <div id="div-area-image2">
                    <a href=""><img src="imagens/atendimentoAdm/icons8-facebook-50 1.png" alt=""></a>
                    <a href=""><img src="imagens/atendimentoAdm/icons8-instagram-64 1.png" alt=""></a>
                    <a href=""><img src="imagens/atendimentoAdm/icons8-linkedin-50 1.png" alt=""></a>
                </div>
            </div>
            <div id="div-area-footer2">
                <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
                <a href=""><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
                <a href=""><p style="height: 10%; text-decoration: underline;">Contato</p></a>
            </div>
        </div>
    </div>   

</body>
</html>