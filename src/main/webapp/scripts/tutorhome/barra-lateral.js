var active_nav_lateral = document.querySelector(".iniciar-barra");
active_nav_lateral.addEventListener("click", function() {
  var barra_lateral = document.querySelector("#barra-ferramentas");
  barra_lateral.style.display = "flex";
});
var active_nav_lateral = document.querySelector(".iniciar-barra2");
active_nav_lateral.addEventListener("click", function() {
  var barra_lateral = document.querySelector("#barra-ferramentas");
  barra_lateral.style.display = "flex";
});

var desative_nav_lateral = document.querySelector("#shadow-zone");
desative_nav_lateral.addEventListener("click", function() {
  var barra_lateral = document.querySelector("#barra-ferramentas");
  barra_lateral.style.display = "none";
});
