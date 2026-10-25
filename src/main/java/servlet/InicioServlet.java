package servlet;

import Daos.InicioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedList;

import Clases.AlquilerVista;

@WebServlet({ "/InicioServlet", "/inicioServlet" })
public class InicioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));    		
            String estado = request.getParameter("estado");
            String fecha = request.getParameter("fecha");

            if (estado == null) estado = "";
            if (fecha == null) fecha = "";

    		InicioDao alquileresRepository = new InicioDao();
    		
    		alquileresRepository.actualizarEstados(idUsuario);


    		LinkedList<AlquilerVista> listaAlquileres = alquileresRepository.listarPorUsuario(idUsuario,estado,fecha);

    		request.setAttribute("alquileres", listaAlquileres);

    		request.getRequestDispatcher("/Inicio/Inicio.jsp").forward(request, response);
    }
}