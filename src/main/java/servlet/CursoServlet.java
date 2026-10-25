package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import Clases.Curso;
import Daos.CursosDao;

/**
 * Servlet implementation class CursoServlet
 */
@WebServlet({ "/CursoServlet", "/cursoServlet" })
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		CursosDao cursosRepository = new CursosDao();
		
		LinkedList<Curso> listaCursos = cursosRepository.listarCursos(idUsuario);
		
		request.setAttribute("cursos", listaCursos);
		
		request.getRequestDispatcher("/Cursos/curso.jsp").forward(request, response);
	}

}
