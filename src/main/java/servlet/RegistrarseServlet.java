package servlet;
import Daos.RegistroDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegistrarseServlet
 */

@WebServlet({ "/RegistrarseServlet", "/registrarseServlet" })
public class RegistrarseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		    protected void doPost(HttpServletRequest request,
		                          HttpServletResponse response)
		            throws ServletException, IOException {

		        String email = request.getParameter("email");
		        String contrasena = request.getParameter("contrasena");
		        String apellido = request.getParameter("apellido");
		        String nombre = request.getParameter("nombre");
		        String documento = request.getParameter("documento");
		        String direccion = request.getParameter("direccion");
		        String telefono = request.getParameter("telefono");

		        System.out.println(
		            "Registrando: " + email + " " + nombre + " " + apellido
		        );
		        if (direccion != null && direccion.isBlank()) {
		        	direccion = null;
		        }
		        if (telefono != null && telefono.isBlank()) {
		            telefono = null;
		        }
		        
		        RegistroDao registro = new RegistroDao();
		        boolean mailExiste = registro.existeEmail(email);
		        if(mailExiste) {
		        	response.getWriter().print("existeMail");
		        }else {
		        	boolean registroCorrecto = registro.registrar(email, contrasena, apellido, nombre, documento, direccion, telefono);	
		        	response.setContentType("text/plain");
		        	if(registroCorrecto) {
		        		response.getWriter().print("ok");
		        	} else {
		        		response.getWriter().print("error");
		        	}
		        }
		        
		    }
}

