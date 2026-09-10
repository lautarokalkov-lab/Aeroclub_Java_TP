const usuario = document.getElementById("usuario");
const contrasena = document.getElementById("contrasena");
const acceder = document.getElementById("acceder");
const registrarse = document.getElementById("registrarse");

registrarse.addEventListener("click", registro);
function registro() {
  window.location.replace("../Registrarse/registrarse.html");
}
