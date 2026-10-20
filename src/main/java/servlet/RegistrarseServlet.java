package servlet;
import Daos.RegistroDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Clases.Usuario;

/**
 * Servlet implementation class RegistrarseServlet
 */

@WebServlet({ "/RegistrarseServlet", "/registrarseServlet" })
public class RegistrarseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		    protected void doPost(HttpServletRequest request,
		                          HttpServletResponse response)
		            throws ServletException, IOException {
		    	
		    	Usuario user = new Usuario();
		    	
		        user.setEmail(request.getParameter("email"));
		        user.setContraseña(request.getParameter("contrasena"));
		        user.setApellido(request.getParameter("apellido"));
		        user.setNombre(request.getParameter("nombre"));
		        user.setNro_doc(request.getParameter("documento"));
		        user.setDomicilio(request.getParameter("direccion"));
		        user.setTelefono(request.getParameter("telefono"));

		        System.out.println("Registrando: " + user.getEmail() + " " + user.getNombre() + " " + user.getApellido());
		        if (user.getDomicilio() != null && user.getDomicilio().isBlank()) {
		        	user.setDomicilio(null);
		        }
		        if (user.getTelefono() != null && user.getTelefono().isBlank()) {
		        	user.setTelefono(null);
		        } //direccion y telefono pueden no tener datos y le asigno nulo
		        
		        RegistroDao registroRepository = new RegistroDao();
		        boolean mailExiste = registroRepository.existeEmail(user.getEmail());
		        if(mailExiste) {
		        	response.getWriter().print("existeMail");
		        }else {
		        	boolean registroCorrecto = registroRepository.registrar(user);	
		        	response.setContentType("text/plain");
		        	if(registroCorrecto) {
		        		response.getWriter().print("ok");
		        	} else {
		        		response.getWriter().print("error");
		        	}
		        }
		        
		    }
}

