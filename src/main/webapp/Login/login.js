const usuario = document.getElementById("usuario");
const contrasena = document.getElementById("contrasena");
const acceder = document.getElementById("acceder");
const registrarse = document.getElementById("registrarse");
const datoIncorrecto = document.getElementById("datoIncorrecto");

registrarse.addEventListener("click", registro);
function registro() {
  window.location.replace("../Registrarse/registrarse.html");
}

acceder.addEventListener("click", iniciarSesion);
function iniciarSesion() {
  const user = usuario.value;
  const contra = contrasena.value;

  if (user == "" || contra == "") {
    console.log("Falta algun dato");
    datoIncorrecto.innerText = "Llene todos los campos";
  } else {
		const parametros = new URLSearchParams({
		    usuario: user,
		    contrasena: contra
		});
	
		fetch("../IngresoServlet?" + parametros)
	      .then((response) => response.text())
	      .then((respuesta) => {
	        respuesta = respuesta.trim(); //respuesta trae palabra/r/n, con trim() saco todo eso
			console.log("respuesta: ", respuesta);

		        if (respuesta != "false") {
		          localStorage.setItem("idUsuario", respuesta);
				  window.location.href = "../InicioServlet?idUsuario=" + respuesta;
		        } else {
		          datoIncorrecto.innerText = "Usuario o Contraseña incorrectos";
				  console.log("Dato incorrecto");
		        }
				

      });
  }
}
