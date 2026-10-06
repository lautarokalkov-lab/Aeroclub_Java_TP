<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AeroClub</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ConfirmarAlquiler/confirmarAlquiler.css" />
  </head>
  <body>
    <header>
      <div id="logo"></div>
      <div id="salir"></div>
    </header>

    <div class="sidebar">
      <h2>Menú</h2>
      <ul>
        <li><a id="inicio" href="#">Inicio</a></li>
        <li><a id="nuevoAlquiler" href="#">Nuevo Alquiler</a></li>
        <li><a id="cursos" href="#">Cursos</a></li>
        <li><a id="sobreNosotros" href="#">Sobre Nosotros</a></li>
      </ul>
    </div>
    <section id="contenido">
      <h1 id="titulo">Confirmar Alquiler</h1>

      <div id="datosAvion">
        <table>
          <thead>
            <tr>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr id="avion">
              <td colspan="2">Avion</td>
            </tr>
            <tr>
              <td>Modelo:</td>
              <td id="modelo" class="fila2">${avion.modelo}</td>
            </tr>
            <tr>
              <td>Matricula:</td>
              <td id="matricula" class="fila2">${avion.matricula}</td>
            </tr>
            <tr class="separar">
              <td>Precio/Hora:</td>
              <td id="precio_hora" class="fila2">${avion.precio_hora}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <div id="datosAlquiler">
        <table>
          <thead>
            <tr>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr id="alquiler">
              <td colspan="2">Alquiler</td>
            </tr>
            <tr>
              <td>Fecha de salida:</td>
              <td id="fechaSalida" class="fila2">${fechaInicio}</td>
            </tr>
            <tr class="separar">
              <td>Hora de salida:</td>
              <td id="horaSalida" class="fila2">${horaInicio}</td>
            </tr>
            <tr class="separar">
              <td>Horas de vuelo:</td>
              <td id="horaVuelo" class="fila2">${horasVuelo}</td>
            </tr>
            <tr>
              <td>Costo total:</td>
              <td id="costo" class="fila2">$${costoTotal}</td>
            </tr>
          </tbody>
        </table>
      </div>

		<form
		    action="${pageContext.request.contextPath}/GuardarAlquilerServlet"
		    method="POST">		
		    <input type="hidden" name="idUsuario" value="${idUsuario}">
		    <input type="hidden" name="idAvion" value="${idAvion}">		
		    <input type="hidden" name="fechaInicio" value="${fechaInicio}">
		    <input type="hidden" name="horaInicio" value="${horaInicio}">
		    <input type="hidden" name="horasVuelo" value="${horasVuelo}">		    
		    <input type="hidden" name="costoTotal" value="${costoTotal}">
		    <div id="botones">	
			    <button type="button" id="cancelar">Cancelar</button>
			    <button type="submit" id="confirmar">Confirmar</button>
		    </div>
		</form>
    </section>
    <script>
    	const contexto = "${pageContext.request.contextPath}";
	</script>
    <script src="${pageContext.request.contextPath}/ConfirmarAlquiler/confirmarAlquiler.js"></script>
  </body>
</html>
