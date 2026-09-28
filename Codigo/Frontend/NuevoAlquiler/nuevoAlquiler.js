const salir = document.getElementById("salir");
const sobreNosotros = document.getElementById("sobreNosotros");
const inicio = document.getElementById("inicio");
const logo = document.getElementById("logo");
const cursos = document.getElementById("cursos");

salir.addEventListener("click", logOut);
function logOut() {
  window.location.replace("../Login/login.html");
}

sobreNosotros.addEventListener("click", Nosotros);
function Nosotros() {
  window.location.replace("../SobreNosotros/sobreNosotros.html");
}

logo.addEventListener("click", pagPrincipal);
inicio.addEventListener("click", pagPrincipal);
function pagPrincipal() {
  window.location.replace("../Inicio/inicio.html");
}

cursos.addEventListener("click", pagCursos);
function pagCursos() {
  window.location.replace("../Cursos/curso.html");
}
