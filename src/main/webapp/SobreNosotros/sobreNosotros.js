const salir = document.getElementById("salir");
const inicio = document.getElementById("inicio");
const logo = document.getElementById("logo");
const cursos = document.getElementById("cursos");
const nuevoAlquiler = document.getElementById("nuevoAlquiler");

const idUsuario = localStorage.getItem("idUsuario");

salir.addEventListener("click", logOut);
function logOut() {
  window.location.replace("../Login/login.html");
}

inicio.addEventListener("click", volver);
logo.addEventListener("click", volver);
function volver() {
  window.location.href = "../InicioServlet?idUsuario=" + idUsuario;
}

nuevoAlquiler.addEventListener("click", IrNuevoAlquiler);
function IrNuevoAlquiler() {
  window.location.href = "../NuevoAlquilerServlet?idUsuario=" + idUsuario;
}

cursos.addEventListener("click", pagCursos);
function pagCursos() {
  window.location.replace("../Cursos/curso.html");
}
