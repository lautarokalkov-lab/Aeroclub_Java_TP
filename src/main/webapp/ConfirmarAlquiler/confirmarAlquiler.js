const salir = document.getElementById("salir");
const inicio = document.getElementById("inicio");
const nuevoAlquiler = document.getElementById("nuevoAlquiler");
const sobreNosotros = document.getElementById("sobreNosotros");
const cursos = document.getElementById("cursos");
const cancelar = document.getElementById("cancelar");
const confirmar = document.getElementById("confirmar");

const idUsuario = localStorage.getItem("idUsuario");

salir.addEventListener("click", logOut);
function logOut() {
  window.location.replace("../Login/login.html");
}

sobreNosotros.addEventListener("click", Nosotros);
function Nosotros() {
  window.location.replace("../SobreNosotros/sobreNosotros.html");
}

cursos.addEventListener("click", curso);
function curso() {
  window.location.replace("../Cursos/curso.html");
}

inicio.addEventListener("click", volver);
logo.addEventListener("click", volver);
function volver() {
  window.location.href = contexto + "/InicioServlet?idUsuario=" + idUsuario;
}
cancelar.addEventListener("click", IrNuevoAlquiler);
nuevoAlquiler.addEventListener("click", IrNuevoAlquiler);
function IrNuevoAlquiler() {
  window.location.href = contexto + "/NuevoAlquilerServlet?idUsuario=" + idUsuario;
}

