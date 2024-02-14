var criar = document.getElementById("button-section");

criar.addEventListener("click",ativartela);

var fecharconfig = document.getElementById("fechar-criar-meta");

fecharconfig.addEventListener("click",desativartela);

function ativartela(event){
    event.preventDefault();
    var corpo = document.getElementById("corpo-criar-meta");
    rolarparacima();
    corpo.style.display = "flex";
}

function desativartela(event){
    event.preventDefault();
    var corpo = document.getElementById("corpo-criar-meta");
    corpo.style.display = "none";
}

function rolarparacima(){
    window.scroll({
        top: 0,
        left: 0,
        behavior: "smooth"
    });
}