package servlet;
import Daos.NuevoAlquilerDao;
import Clases.AvionDisponible;
import Clases.NuevoAlquiler;
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

        NuevoAlquilerDao NuevoAlquilerRepository = new NuevoAlquilerDao();

        LinkedList<String> modelos = NuevoAlquilerRepository.listarModelos(idUsuario);

        request.setAttribute("modelos", modelos);
        request.getRequestDispatcher("/NuevoAlquiler/nuevoAlquiler.jsp").forward(request, response);
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
    	NuevoAlquiler alquiler = new NuevoAlquiler();
    	
    	alquiler.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));

        alquiler.setFechaInicio(request.getParameter("fechaInicio"));        
        alquiler.setHoraInicio(request.getParameter("horaInicio"));
        alquiler.setHorasVuelo(Integer.parseInt(request.getParameter("horasVuelo")));
        alquiler.setModelo(request.getParameter("modelo"));

        if(alquiler.getHorasVuelo() >0) {
        	NuevoAlquilerDao NuevoAlquilerRepository = new NuevoAlquilerDao();
        	
        	LinkedList<AvionDisponible> aviones =
        			NuevoAlquilerRepository.buscarDisponibles(alquiler);
        	
        	
        	LinkedList<String> modelos = NuevoAlquilerRepository.listarModelos(alquiler.getIdUsuario());
        	
        	request.setAttribute("modelos", modelos);
        	request.setAttribute("aviones", aviones);
        	
        	request.getRequestDispatcher("/NuevoAlquiler/nuevoAlquiler.jsp").forward(request, response);        	
        }
    }
}
