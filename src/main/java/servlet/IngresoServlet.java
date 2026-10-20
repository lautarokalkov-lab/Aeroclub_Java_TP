package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Daos.IngresoDao;

/**
 * Servlet implementation class IngresoServlet
 */
@WebServlet({ "/IngresoServlet", "/ingresoServlet" })
public class IngresoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response)
            		throws ServletException, IOException {
		
        String user = request.getParameter("usuario");
        String contra = request.getParameter("contrasena");
        
        IngresoDao ingresoRepository = new IngresoDao();
        
        int id = ingresoRepository.acceder(user, contra);
        System.out.println("ID: "+ id);
        
        response.setContentType("text/plain");
        
        if(id != 0) {
        	String idUsuario = String.valueOf(id);	
    		response.getWriter().println(idUsuario);
    		
        } else {
    		response.getWriter().println("false");
        }
        
	}

}
