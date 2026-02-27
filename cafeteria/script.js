function mover(direccion){
  const track = document.getElementById("track");
  const ancho = 280;

  track.scrollBy({
    left: direccion * ancho,
    behavior: 'smooth'
  });
}