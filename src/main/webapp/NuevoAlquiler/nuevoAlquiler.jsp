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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/NuevoAlquiler/nuevoAlquilerStyles.css" />
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

    <div class="alquileres">
    	<div id="filtros">
			<form action="${pageContext.request.contextPath}/NuevoAlquilerServlet" method="POST">
			
			    <input
			        type="hidden"
			        name="idUsuario"
			        value="${param.idUsuario}">
			    
			    <label>Fecha Salida:</label>
			    <input
				    id="filtroFechaIni"
				    name="fechaInicio"
				    type="date"
				    value="${param.fechaInicio}"
				    required
				/>
						    
			
			    <label>Hora Salida:</label>
			    <input
			        id="horaIni"
			        name="horaInicio"
			        type="time"
			        value="${param.horaInicio}"
			        required
			    />
			
			    <label>Horas de vuelo:</label>
			    <input
			        id="horasVuelo"
			        name="horasVuelo"
			        type="number"
			        value="${param.horasVuelo}"
			        required
			    />
			
			    <select name="modelo">
			        <option value="">Todos los modelos</option>
			
			        <c:forEach var="modelo" items="${modelos}">
			            <option value="${modelo}">
			                ${modelo}
			            </option>
			        </c:forEach>			
			    </select>
			
			    <button id="botonBuscar" type="submit">
			        Buscar
			    </button>
			
			</form>
		</div>

      <div id="listaAlquileres">
        <table>
          <thead>
            <tr>
              <th>Modelo de avión</th>
              <th>Matrícula</th>
              <th>Costo por hora</th>
              <th></th>
            </tr>
          </thead>

			<tbody>
			
			    <c:forEach var="avion" items="${aviones}">			
			        <tr>			
			            <td>
			                ${avion.modelo}
			            </td>
			
			            <td>
			                ${avion.matricula}
			            </td>
			
			            <td>
			                ${avion.precio_hora}
			            </td>
			
			            <td>			
			                <form
			                    action="${pageContext.request.contextPath}/ConfirmarAlquilerServlet"
			                    method="GET">
			
			                    <input type="hidden" name="idAvion" value="${avion.id}">
								<input type="hidden" name="idUsuario" value="${param.idUsuario}">								
								<input type="hidden" name="fechaInicio" value="${param.fechaInicio}">
								<input type="hidden" name="horaInicio" value="${param.horaInicio}">
								<input type="hidden" name="horasVuelo" value="${param.horasVuelo}">			                        
			
			                    <button type="submit">Alquilar</button>			
			                </form>			
			            </td>			
			        </tr>			
			    </c:forEach>			
			</tbody>
        </table>
      </div>
    </div>
	<script>
    	const contexto = "${pageContext.request.contextPath}";
	</script>
    <script src="${pageContext.request.contextPath}/NuevoAlquiler/nuevoAlquiler.js"></script>
  </body>
</html>
