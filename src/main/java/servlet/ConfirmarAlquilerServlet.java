package servlet;
import Daos.BuscarAvionDao;
import Clases.AvionDisponible;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ConfirmarAlquilerServlet
 */
@WebServlet({ "/ConfirmarAlquilerServlet", "/confirmarAlquilerServlet" })
public class ConfirmarAlquilerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idAvion = request.getParameter("idAvion");
        String idUsuario = request.getParameter("idUsuario");
        String fechaInicio = request.getParameter("fechaInicio");     
        String horaInicio = request.getParameter("horaInicio");
        String horasVuelo = request.getParameter("horasVuelo");
        
        BuscarAvionDao buscar = new BuscarAvionDao();
        AvionDisponible avion = new AvionDisponible();
        avion = buscar.buscarAvion(idAvion);
        double costoTotal = avion.getPrecio_hora() * Integer.parseInt(horasVuelo);

        request.setAttribute("costoTotal", costoTotal);
        request.setAttribute("avion", avion);
        request.setAttribute("idAvion", idAvion);
        request.setAttribute("idUsuario", idUsuario);
        request.setAttribute("fechaInicio", fechaInicio);        
        request.setAttribute("horaInicio", horaInicio);
        request.setAttribute("horasVuelo", horasVuelo);

        request.getRequestDispatcher("/ConfirmarAlquiler/confirmarAlquiler.jsp").forward(request, response);
    }
}
