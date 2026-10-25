const salir = document.getElementById("salir");
const sobreNosotros = document.getElementById("sobreNosotros");
const botonNuevoAlquiler = document.getElementById("botonNuevoAlquiler");
const nuevoAlquiler = document.getElementById("nuevoAlquiler");
const cursos = document.getElementById("cursos");
const tabla = document.getElementById("listaAlquileres");

const idUsuario = localStorage.getItem("idUsuario");

salir.addEventListener("click", logOut);
function logOut() {
    window.location.replace(contexto + "/Login/login.html");
}


sobreNosotros.addEventListener("click", Nosotros);
function Nosotros() {
    window.location.replace(contexto + "/SobreNosotros/sobreNosotros.html");
}


nuevoAlquiler.addEventListener("click", IrNuevoAlquiler);
botonNuevoAlquiler.addEventListener("click", IrNuevoAlquiler);

function IrNuevoAlquiler() {
    window.location.href = contexto + "/NuevoAlquilerServlet?idUsuario=" + idUsuario;
}


cursos.addEventListener("click", curso);
function curso() {
    window.location.href = contexto + "/CursoServlet?idUsuario=" + idUsuario;
}



console.log("Id: ", idUsuario);