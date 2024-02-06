<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="imagens/cadastro/Frame 1.png" type="image/png">
  <title>Tutoria</title>
</head>
<link rel="stylesheet" href="styles/tutoradoEdicao/tutoradoEdicao.css">
<body>
<script src="barra-lateral.js"></script>
<script src="menu-entrar-tutoria.js"></script>
<script src="cards.js" defer></script>
<script src="verificar-entrar-tutoria.js"></script>

<div id="container">
  <div id="shadow-entrar-tutoria">
    <div id="div-entrar-tutoria">
      <div id="entrar-tutoria-exit">
        <div id="entrar-tutoria-exit-space"></div>
        <img id="entrar-tutoria-exit-image" src="imagens/icons8-fechar-janela-96.png" alt="">
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
      <div id="nav-lateral-image"><a href=""><img src="imagens/icons8-usuário-homem-com-círculo-100.png" alt="icons8-usuário-homem-com-círculo-100.png"></a></div>
      <div id="nav-lateral-name"><a href=""><p>Rodrigo Costa</p></a></div>
      <div id="nav-lateral-option1"><a href="">Editar Perfil</a></div>
      <div id="nav-lateral-option2"><a href="">Nova Tutoria</a></div>
      <div id="nav-lateral-option3"><a href="">Sair</a></div>
    </div>
  </div>

  <div id="navbar">
    <div id="navbar-logo">
      <div> <a href="voltarParaMainTutorado?id=<%= request.getParameter("id")%>"> <img src="imagens/cadastro/Frame 1.png" id="navbar-image" alt="frame.png"> </a></div>
      <div id="navbar-name"> <a href="voltarParaMainTutorado?id=<%= request.getParameter("id")%>"> <p>Tutoria</p><p>De</p><p>Pares</p> </a></div>
    </div>
  </div>

  <div id="container-main">
    <div id="container-conteudo">
      <h1 id="section-titulo">Edi&ccedil;&atilde;o de dados</h1>
      <hr>
      <form action="realizarEdicaoDoTutorado" id="editarTutorado" name="editarTutorado"  onsubmit="return validarFormulario()">

        <div class="half">

          <div class="form-grupo">
            <label class="form-label">Seu identificador (id)</label>
            <input type="text" name="id" class="form-input" readonly style="font-size: 1.2rem"  value="<%out.print(request.getAttribute("id"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Digite sua nova senha</label>
            <input type="text" name="senha" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("senha"));%>">
          </div>

        </div>

        <div class="half">
          <div class="form-grupo">
            <label class="form-label">Digite seu novo nome</label>
            <input type="text" name="nome" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("nome"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Digite seu novo e-mail</label>
            <input type="email" name="email" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("email"));%>">
          </div>
        </div>

        <div class="half">
          <div class="form-grupo">
            <label class="form-label">Digite seu novo curso</label>
            <input type="text" name="curso" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("curso"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Digite seu novo semestre</label>
            <input type="text" name="semestre" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("semestre"));%>">
          </div>
        </div>

        <div class="half">
          <div class="form-grupo">
            <label class="form-label">Digite sua defici&ecirc;ncia</label>
            <input type="text" name="deficiencia" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("deficiencia"));%>">
          </div>

          <div class="form-grupo">
            <label class="form-label">Digite sua nova matr&iacute;cula</label>
            <input type="text" name="matricula" class="form-input" style="font-size: 1.2rem" value="<%out.print(request.getAttribute("matricula"));%>">
          </div>
        </div>
        <div id="mensagemDeErro" style="color: red; margin-bottom: 50px; font-size: 20px; display: flex; align-items: center; justify-content:center;"></div>
        <footer id="main-footer">
          <button id="button-submit" type="submit">Atualizar</button>
        </footer>
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

<script src="scripts/edicao/validarTutoradoEdicao.js"></script>
<script src="menu-entrar-tutoria.js"></script>
<script src="barra-lateral.js"></script>
<script src="cards.js"></script>

</body>
</html>