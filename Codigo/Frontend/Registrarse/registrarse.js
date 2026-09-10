const mail = document.getElementById("mail");
const contrasena = document.getElementById("contrasena");
const documento = document.getElementById("documento");
const nombre = document.getElementById("nombre");
const apellido = document.getElementById("apellido");
const direccion = document.getElementById("direccion");
const telefono = document.getElementById("telefono");
const crear = document.getElementById("crear");
const volver = document.getElementById("volver");

volver.addEventListener("click", atras);
function atras() {
  window.location.replace("../Login/login.html");
}
