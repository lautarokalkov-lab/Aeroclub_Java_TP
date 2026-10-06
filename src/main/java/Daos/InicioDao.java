package Daos;
import Clases.AlquilerVista;

import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InicioDao {
	
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
    
	public LinkedList<AlquilerVista> listarPorUsuario(int idUsuario) {

	    LinkedList<AlquilerVista> alquileres = new LinkedList<>();
	    
	    String sql =
	        "SELECT " +
	        "avion.modelo, " +
	        "avion.matricula, " +
	        "alquiler.fecha_inicio, " +
	        "alquiler.hora_inicio, " +
	        "alquiler.horasVuelo, " +
	        "alquiler.costo_total, "+
	        "alquiler.estado " +
	        "FROM alquiler " +
	        "JOIN avion ON avion.id_avion = alquiler.id_avion " +
	        "WHERE alquiler.id_usuario = ? " +
	        "ORDER BY CASE alquiler.estado " +
	        "when 'Activo' then 1 when 'Pendiente' then 2 when 'Finalizado' then 3 end, alquiler.fecha_inicio";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (
	            Connection conexion =
	                DriverManager.getConnection(url, usuarioSql, contraseñaSql);

	            PreparedStatement sentencia =
	                conexion.prepareStatement(sql)
	        ) {

	            sentencia.setInt(1, idUsuario);
	            ResultSet resultado = sentencia.executeQuery();

	            while (resultado.next()) {
	                AlquilerVista alquiler = new AlquilerVista();
	                alquiler.setModelo(resultado.getString("modelo"));
	                alquiler.setMatricula(resultado.getString("matricula"));
	                alquiler.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
	                alquiler.setHoraInicio(resultado.getTime("hora_inicio").toLocalTime());
	                alquiler.setHorasVuelo(resultado.getInt("horasVuelo"));
	                alquiler.setCostoTotal(resultado.getDouble("costo_total"));
	                alquiler.setEstado(resultado.getString("estado"));
	                alquileres.add(alquiler);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return alquileres;
	}
	
	public void actualizarEstados(int idUsuario) {

	    String sqlFinalizar =
	        "UPDATE alquiler " +
	        "SET estado = 'Finalizado' " +
	        "WHERE id_usuario = ? " +
	        "AND estado IN ('Pendiente', 'Activo') " +
	        "AND TIMESTAMP(fecha_inicio, hora_inicio) " +
	        "    + INTERVAL horasVuelo HOUR <= NOW()";

	    String sqlActivar =
	        "UPDATE alquiler " +
	        "SET estado = 'Activo' " +
	        "WHERE id_usuario = ? " +
	        "AND estado = 'Pendiente' " +
	        "AND TIMESTAMP(fecha_inicio, hora_inicio) <= NOW() " +
	        "AND TIMESTAMP(fecha_inicio, hora_inicio) " +
	        "    + INTERVAL horasVuelo HOUR > NOW()";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection conexion =DriverManager.getConnection(url, usuarioSql, contraseñaSql)) {
	            
	            try (PreparedStatement sentencia = conexion.prepareStatement(sqlFinalizar)) {

	                sentencia.setInt(1, idUsuario);
	                sentencia.executeUpdate();
	            }
	            
	            try (PreparedStatement sentencia = conexion.prepareStatement(sqlActivar)) {

	                sentencia.setInt(1, idUsuario);
	                sentencia.executeUpdate();
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
