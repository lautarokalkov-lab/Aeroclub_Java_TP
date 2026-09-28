const salir = document.getElementById("salir");
const inicio = document.getElementById("inicio");
const logo = document.getElementById("logo");
const cursos = document.getElementById("cursos");
const nuevoAlquiler = document.getElementById("nuevoAlquiler");

salir.addEventListener("click", logOut);
function logOut() {
  window.location.replace("../Login/login.html");
}

inicio.addEventListener("click", volver);
logo.addEventListener("click", volver);
function volver() {
  window.location.replace("../inicio/inicio.html");
}

nuevoAlquiler.addEventListener("click", IrNuevoAlquiler);
function IrNuevoAlquiler() {
  window.location.replace("../NuevoAlquiler/nuevoAlquiler.html");
}

cursos.addEventListener("click", pagCursos);
function pagCursos() {
  window.location.replace("../Cursos/curso.html");
}
