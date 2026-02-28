const track = document.getElementById("track");
let index = 0;

function autoSlide(){
  const items = document.querySelectorAll(".categorias__item");
  const visible = 4;
  const total = items.length;

  index++;

  if(index > total - visible){
    index = 0;
  }

  const slideWidth = items[0].offsetWidth + 24; // incluye gap
  track.style.transform = `translateX(-${index * slideWidth}px)`;
}

setInterval(autoSlide, 3000);