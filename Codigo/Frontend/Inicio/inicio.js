const salir = document.getElementById("salir");
const sobreNosotros = document.getElementById("sobreNosotros");

salir.addEventListener("click", logOut);
function logOut() {
  window.location.replace("../Login/login.html");
}

sobreNosotros.addEventListener("click", Nosotros);
function Nosotros() {
  window.location.replace("../SobreNosotros/sobreNosotros.html");
}
