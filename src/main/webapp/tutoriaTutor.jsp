<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
  <link rel="stylesheet" href="styles/tutoria/tutoria.css">
  <title>Tutoria</title>
</head>

<body>
<script src="barra-lateral.js"></script>
<script src="menu-entrar-tutoria.js"></script>
<script src="cards.js" defer></script>
<script src="verificar-entrar-tutoria.js"></script>

<div id="container">

  <div id="navbar">
    <div id="navbar-logo">
      <div> <a href="voltarParaMainTutor?id=<%= request.getParameter("id")%>"> <img src="imagens/cadastro/Frame 1.png" id="navbar-image" alt="frame.png"> </a></div>
      <div id="navbar-name"> <a href="voltarParaMainTutor?id=<%= request.getParameter("id")%>"> <p>Tutoria</p><p>De</p><p>Pares</p> </a></div>
    </div>
  </div>

  <div id="container-main">
    <div id="container-conteudo">
      <h1 id="section-titulo">Tutoria</h1>
      <hr>
      <form action="" id="editarTutorado" name="">

        <div class="half">

          <div class="form-grupo">
            <label class="form-label">Código da tutoria</label>
            <input type="text" name="codigo" class="form-input" readonly style="font-size: 1.2rem"  value="<%out.print(request.getAttribute("codigo"));%>">
          </div>

          <div class="form-grupo">
             <label class="form-label">Nome do professor</label>
             <input type="email" name="nomeProfessor" class="form-input" readonly readonly style="font-size: 1.2rem" value="<%out.print(request.getAttribute("nomeProfessor"));%>">
          </div>

        </div>

        <div class="half">
          <div class="form-grupo">
            <label class="form-label">Senha da tutoria</label>
            <input type="text" name="senha" class="form-input" readonly style="font-size: 1.2rem" value="<%out.print(request.getAttribute("senha"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Nome do tutor</label>
            <input type="email" name="nomeTutor" class="form-input" readonly style="font-size: 1.2rem" value="<%out.print(request.getAttribute("nomeTutor"));%>">
          </div>
        </div>

        <div class="half">
          <div class="form-grupo">
            <label class="form-label">Nome do tutorado</label>
            <input type="text" name="nomeTutorado" class="form-input" readonly style="font-size: 1.2rem" value="<%out.print(request.getAttribute("nomeTutorado"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Disciplina</label>
            <input type="text" name="disciplina" class="form-input" readonly style="font-size: 1.2rem" value="<%out.print(request.getAttribute("disciplina"));%>">
          </div>
        </div>


         <div class="half" id="footer3">
                    <div class="footer-grupo" id="footer1">
                       <button id="button-submit" type="submit">Ver Atendimentos</button>
                     </div>

                     <div class="footer-grupo" id="footer2">
                       <button id="button-submit" type="submit">Ver Metas</button>
                      </div>
                </div>
      </form>

    </div>
  </div>

  <div id="div-area">
    <div id="div-area-footer1">
      <div id="div-area-image1">
        <img id="image-main-footer" src="imagens/cadastro/Frame 1.png" alt="">
      </div>
      <div id="div-area-image2">
        <a href=""><img src="imagens/cadastro/icons8-facebook-50 1.png" alt=""></a>
        <a href=""><img src="imagens/cadastro/icons8-instagram-64 1.png" alt=""></a>
        <a href=""><img src="imagens/cadastro/icons8-linkedin-50 1.png" alt=""></a>
      </div>
    </div>
    <div id="div-area-footer2">
      <strong><p style="font-size: 1.3rem; height: 80%;">Informações:</p></strong>
      <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Sobre</p></a>
      <a href="sobre.html" target="_blank"><p style="height: 10%; text-decoration: underline;">Contato</p></a>
    </div>
  </div>
</div>

<script src="scripts/edicao/validadorTutorEdicao.js"></script>
<script src="menu-entrar-tutoria.js"></script>
<script src="barra-lateral.js"></script>
<script src="cards.js"></script>

</body>
</html>