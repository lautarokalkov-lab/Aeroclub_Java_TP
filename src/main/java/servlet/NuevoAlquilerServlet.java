package servlet;
import Daos.NuevoAlquilerDao;
import Clases.AvionDisponible;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Servlet implementation class NuevoAlquilerServlet
 */
@WebServlet({ "/NuevoAlquilerServlet", "/nuevoAlquilerServlet" })
public class NuevoAlquilerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        NuevoAlquilerDao dao = new NuevoAlquilerDao();

        LinkedList<String> modelos = dao.listarModelos(idUsuario);

        request.setAttribute("modelos", modelos);
        request.getRequestDispatcher("/NuevoAlquiler/nuevoAlquiler.jsp").forward(request, response);
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        String fechaInicio = request.getParameter("fechaInicio");        
        String horaInicio = request.getParameter("horaInicio");
        int horasVuelo = Integer.parseInt(request.getParameter("horasVuelo"));
        String modelo = request.getParameter("modelo");

        if(horasVuelo >0) {
        	NuevoAlquilerDao dao = new NuevoAlquilerDao();
        	
        	LinkedList<AvionDisponible> aviones =
        			dao.buscarDisponibles(
        					idUsuario,
        					fechaInicio,                    
        					horaInicio,
        					horasVuelo,
        					modelo
        					);
        	
        	
        	LinkedList<String> modelos = dao.listarModelos(idUsuario);
        	
        	request.setAttribute("modelos", modelos);
        	request.setAttribute("aviones", aviones);
        	
        	request.getRequestDispatcher("/NuevoAlquiler/nuevoAlquiler.jsp").forward(request, response);        	
        }
    }
}
