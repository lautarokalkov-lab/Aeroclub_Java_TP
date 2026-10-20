package servlet;

import Daos.GuardarAlquilerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Clases.Alquiler;

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
        	Alquiler alquiler = new Alquiler();
        	
            alquiler.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario"))); 
            alquiler.setIdAvion(Integer.parseInt(request.getParameter("idAvion")));
            alquiler.setFechaInicio(request.getParameter("fechaInicio"));
            alquiler.setHoraInicio(request.getParameter("horaInicio"));
            alquiler.setHorasVuelo(Integer.parseInt(request.getParameter("horasVuelo")));
            alquiler.setCostoTotal(Double.parseDouble(request.getParameter("costoTotal")));


            GuardarAlquilerDao alquilerRepository = new GuardarAlquilerDao();
            alquilerRepository.Guardar(alquiler);
            
            response.sendRedirect(request.getContextPath() + "/NuevoAlquilerServlet?idUsuario=" + alquiler.getIdUsuario());

        } catch (NumberFormatException e) {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Los identificadores no son válidos."
            );
        }
    }
}
