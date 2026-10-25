package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Daos.CursosDao;

/**
 * Servlet implementation class ConfirmarCursoServlet
 */
@WebServlet({ "/ConfirmarCursoServlet", "/confirmarCursoServlet" })
public class ConfirmarCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		
		CursosDao cursosRepository = new CursosDao();
		boolean rta = cursosRepository.GuardarCurso(idUsuario, idCurso);
		if(rta) {
			 response.sendRedirect(request.getContextPath()+ "/CursoServlet?idUsuario=" + idUsuario);
			 //Recargo la pagina de cursos para que desaparezca al que me inscribi
		}else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo registrar la inscripción.");
		}
				
	}

}
