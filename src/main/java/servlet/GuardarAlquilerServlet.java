package servlet;

import Daos.GuardarAlquilerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GuardarAlquilerServlet
 */
@WebServlet({ "/GuardarAlquilerServlet", "/guardarAlquilerServlet" })
public class GuardarAlquilerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            int idAvion = Integer.parseInt(request.getParameter("idAvion"));
            String fechaInicio = request.getParameter("fechaInicio");
            String horaInicio = request.getParameter("horaInicio");
            int horasVuelo = Integer.parseInt(request.getParameter("horasVuelo"));
            double costoTotal = Double.parseDouble(request.getParameter("costoTotal"));


            GuardarAlquilerDao alquilerRepository = new GuardarAlquilerDao();
            alquilerRepository.Guardar(idUsuario, idAvion, fechaInicio, horaInicio, horasVuelo, costoTotal);
            
            response.sendRedirect(request.getContextPath() + "/NuevoAlquilerServlet?idUsuario=" + idUsuario);

        } catch (NumberFormatException e) {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Los identificadores no son válidos."
            );
        }
    }
}
