var entrarTutoria1 = document.querySelector("#shadow-entrar-tutoria");
var entrarTutoria2 = document.querySelector("#navbar-image2");

entrarTutoria2.addEventListener("click",function(){

    entrarTutoria1.style.display = "flex";

});

var sairTutoria = document.querySelector("#entrar-tutoria-exit-image");

sairTutoria.addEventListener("click",function(){

    entrarTutoria1.style.display = "none";

});
