const slider = document.querySelectorAll('.slider');
const btnLeft = document.getElementById("arrow-left");
const btnRight = document.getElementById("arrow-right");

let currentSlide = 0;

function esconderSlider(){
  slider.forEach(item => item.classList.remove('on'));
}

function mostrarSlider(){
  slider[currentSlide].classList.add("on");
}

function nextSlider(){

  esconderSlider();

  if(currentSlide === slider.length - 1){
      currentSlide = 0;
  }else{
    currentSlide++;
  }

  mostrarSlider();

}

function prevSlider(){

  esconderSlider();

  if(currentSlide === 0){
      currentSlide = slider.length - 1;
  }else{
    currentSlide--;
  }

  mostrarSlider();
  
}

btnRight.addEventListener("click",nextSlider);

btnLeft.addEventListener("click",prevSlider);