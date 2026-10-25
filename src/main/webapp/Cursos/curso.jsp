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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Cursos/cursoStyles.css" />
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

    <div id="listaCursos">
      <table>
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Duracion</th>
            <th>Horas de vuelo</th>
            <th>Costo</th>
            <th>Licencia</th>
            <th>Descripcion</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
			
			    <c:forEach var="curso" items="${cursos}">
			
			        <tr>
			
			            <td>${curso.nombre}</td>
			
			            <td>${curso.duracion}</td>
			
			            <td>${curso.horasVuelo}</td>
			
			            <td>$${curso.costo}</td>
			
			            <td>${curso.licencia}</td>
			
			            <td>${curso.descripcion}</td>
			            
			            <td>
				            <form
				                action="${pageContext.request.contextPath}/ConfirmarCursoServlet"
				                method="GET">
				
				                <input type="hidden" name="idCurso" value="${curso.idCurso}">
				                <input type="hidden" name="idUsuario" value="${curso.idUsuario}">
				                <button type="submit">Inscribirse</button>			
			                </form>
			            </td>
			
			        </tr>
			
			    </c:forEach>			
			</tbody>
      </table>
    </div>
    
    <script>
    	const contexto = "${pageContext.request.contextPath}";
	</script>

    <script src="${pageContext.request.contextPath}/Cursos/curso.js"></script>
  </body>
</html>
