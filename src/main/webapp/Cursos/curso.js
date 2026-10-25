const salir = document.getElementById("salir");
const sobreNosotros = document.getElementById("sobreNosotros");
const inicio = document.getElementById("inicio");
const logo = document.getElementById("logo");
const nuevoAlquiler = document.getElementById("nuevoAlquiler");

const idUsuario = localStorage.getItem("idUsuario");

salir.addEventListener("click", logOut);
function logOut() {
	window.location.replace(contexto + "/Login/login.html");
}

sobreNosotros.addEventListener("click", Nosotros);
function Nosotros() {
	window.location.replace(contexto + "/SobreNosotros/sobreNosotros.html");
}

logo.addEventListener("click", pagPrincipal);
inicio.addEventListener("click", pagPrincipal);
function pagPrincipal() {	
	window.location.href = contexto + "/InicioServlet?idUsuario=" + idUsuario;
}
nuevoAlquiler.addEventListener("click", pagNuevoAlq);
function pagNuevoAlq() {
	window.location.href = contexto + "/NuevoAlquilerServlet?idUsuario=" + idUsuario;
}
