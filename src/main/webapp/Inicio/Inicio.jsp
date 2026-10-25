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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Inicio/inicioStyles.css" />
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
      <div id="barraSuperior">
		<form id="formFiltros"
		      action="${pageContext.request.contextPath}/InicioServlet"
		      method="GET">
		
		    <input type="hidden" name="idUsuario" value="${param.idUsuario}">
		
		    <select name="estado" id="filtroEstado">
		        <option value="" ${empty param.estado ? 'selected' : ''}>
		            Todos los estados
		        </option>
		        <option value="Activo" ${param.estado == 'Activo' ? 'selected' : ''}>
		            Activo
		        </option>
		        <option value="Pendiente" ${param.estado == 'Pendiente' ? 'selected' : ''}>
		            Pendiente
		        </option>
		        <option value="Finalizado" ${param.estado == 'Finalizado' ? 'selected' : ''}>
		            Finalizado
		        </option>
		    </select>
		
		    <input
		        id="filtroFecha"
		        name="fecha"
		        type="date"
		        value="${param.fecha}"
		    >
		
		    <button type="submit" id="botonFiltrar">Filtrar</button>
		</form>

        <button id="botonNuevoAlquiler">Nuevo Alquiler</button>
      </div>

      <div id="listaAlquileres">
        <table>
          <thead>
            <tr>
              <th>Modelo de avión</th>
              <th>Matrícula</th>
              <th>Horas de vuelo</th>
              <th>Costo total</th>
              <th>Fecha</th>
              <th>Estado</th>
            </tr>
          </thead>
		 	<tbody>
			
			    <c:forEach var="alquiler" items="${alquileres}">
			
			        <tr>
			
			            <td>${alquiler.modelo}</td>
			
			            <td>${alquiler.matricula}</td>
			
			            <td>${alquiler.horasVuelo}</td>
			
			            <td>$${alquiler.costoTotal}</td>
			
			            <td>${alquiler.fechaInicio}</td>
			
			            <td>${alquiler.estado}</td>
			
			        </tr>
			
			    </c:forEach>			
			</tbody>           
        </table>
      </div>
    </div>

    <script>
    	const contexto = "${pageContext.request.contextPath}";
	</script>

	<script src="${pageContext.request.contextPath}/Inicio/inicio.js"></script>
  </body>
</html>
