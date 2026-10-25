const salir = document.getElementById("salir");
const sobreNosotros = document.getElementById("sobreNosotros");
const inicio = document.getElementById("inicio");
const logo = document.getElementById("logo");
const cursos = document.getElementById("cursos");
const fechaInicio = document.getElementById("filtroFechaIni");
const horaInicio = document.getElementById("horaIni");
const horasVuelo = document.getElementById("horasVuelo");
const formulario = document.querySelector("#filtros form");

const idUsuario = localStorage.getItem("idUsuario");


formulario.addEventListener("submit", almacenar)
function almacenar(){
    localStorage.setItem("fechaInicio", fechaInicio.value);    
    localStorage.setItem("horaInicio", horaInicio.value);
    localStorage.setItem("horasVuelo", horasVuelo.value);
};


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

cursos.addEventListener("click", pagCursos);
function pagCursos() {
  window.location.href = contexto + "/CursoServlet?idUsuario=" + idUsuario;
}
