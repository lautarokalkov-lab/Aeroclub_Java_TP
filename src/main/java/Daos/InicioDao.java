package Daos;
import Clases.AlquilerVista;
import Clases.Conexion;

import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InicioDao {
	
	Conexion conection = new Conexion();
    

	public LinkedList<AlquilerVista> listarPorUsuario(int idUsuario, String estado, String fecha) {
	
	    LinkedList<AlquilerVista> alquileres = new LinkedList<>();
	
	    StringBuilder sql = new StringBuilder(
	        "SELECT avion.modelo, avion.matricula, " +
	        "alquiler.fecha_inicio, alquiler.hora_inicio, " +
	        "alquiler.horasVuelo, alquiler.costo_total, alquiler.estado " +
	        "FROM alquiler " +
	        "JOIN avion ON avion.id_avion = alquiler.id_avion " +
	        "WHERE alquiler.id_usuario = ? "
	    );
		    
	    if (!estado.isEmpty()) {
	        sql.append("AND alquiler.estado = ? ");
	    }
	
	    if (!fecha.isEmpty()) {
	        sql.append("AND alquiler.fecha_inicio = ? ");
	    }
	
	    sql.append(
	        "ORDER BY CASE alquiler.estado " +
	        "WHEN 'Activo' THEN 1 " +
	        "WHEN 'Pendiente' THEN 2 " +
	        "WHEN 'Finalizado' THEN 3 " +
	        "ELSE 4 END, alquiler.fecha_inicio desc"
	    );
	
	    try {
	        Class.forName(conection.getDriver());
	
	        try (
	            Connection conexion = conection.conectar();
	            PreparedStatement sentencia = conexion.prepareStatement(sql.toString())
	        ) {
	            int indice = 1;
	
	            sentencia.setInt(indice++, idUsuario);
	
	            if (!estado.isEmpty()) {
	                sentencia.setString(indice++, estado); //si hay estado, usa el indice 2 y lo aumenta a 3 para el siguiente
	            }
	
	            if (!fecha.isEmpty()) {
	                sentencia.setDate(indice, java.sql.Date.valueOf(fecha)); //si no hay estado usa indice 3, si no hay usa 2
	            }
	
	            try (ResultSet resultado = sentencia.executeQuery()) {
	
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
	        Class.forName(conection.getDriver());

	        try (Connection conexion = conection.conectar()){
	            
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
