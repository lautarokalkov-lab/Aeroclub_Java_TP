const mail = document.getElementById("mail");
const contra = document.getElementById("contrasena");
const doc = document.getElementById("documento");
const nom = document.getElementById("nombre");
const ape = document.getElementById("apellido");
const dire = document.getElementById("direccion");
const tel = document.getElementById("telefono");
const crear = document.getElementById("crear");
const volver = document.getElementById("volver");
const faltaDato = document.getElementById("faltaDato");

volver.addEventListener("click", atras);
function atras() {
  window.location.replace("../Login/login.html");
}

crear.addEventListener("click", crearUsuario);
function crearUsuario(){
    if(
        mail.value != "" &&
        contra.value != "" &&
        ape.value != "" &&
        nom.value != "" &&
        doc.value != ""
    ){
        const parametros = new URLSearchParams({
            email: mail.value,
            contrasena: contra.value,
            apellido: ape.value,
            nombre: nom.value,
            documento: doc.value,
            direccion: dire.value,
            telefono: tel.value
        });

        fetch("../RegistrarseServlet", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: parametros
        })
        .then((response) => response.text())
        .then((respuesta) => {

            respuesta = respuesta.trim();
            console.log("respuesta: ", respuesta);
			if(respuesta == "ok"){
				faltaDato.innerText = "Usuario Creado";
			}
			else if(respuesta == "existeMail"){
				faltaDato.innerText = "El Email ya existe";
			}
			else if(respuesta == "error"){
				faltaDato.innerText = "Error del servidor";
			};

        });

    }else{
        faltaDato.innerText = "Introducir al menos los primeros 5 datos";
    }
}