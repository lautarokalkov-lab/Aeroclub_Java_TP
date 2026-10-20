package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Clases.Alquiler;
import Clases.Conexion;

public class GuardarAlquilerDao {
	Conexion conection = new Conexion();
	
	public void Guardar(Alquiler alquiler) {
		String sql =
				"INSERT INTO alquiler (fecha_inicio, hora_inicio, horasVuelo, estado, costo_total, id_usuario, id_avion)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                Class.forName(conection.getDriver());
                try (
                    Connection conexion = conection.conectar();
                    PreparedStatement sentencia = conexion.prepareStatement(sql)
                ) {
                    sentencia.setString(1, alquiler.getFechaInicio());
                    sentencia.setString(2, alquiler.getHoraInicio());
                    sentencia.setInt(3, alquiler.getHorasVuelo());
                    sentencia.setString(4, "Pendiente");
                    sentencia.setDouble(5, alquiler.getCostoTotal());
                    sentencia.setInt(6, alquiler.getIdUsuario());
                    sentencia.setInt(7, alquiler.getIdAvion());

                    int filasInsertadas = sentencia.executeUpdate();

                    if (filasInsertadas == 0) {
                        throw new Exception("No se pudo guardar el alquiler.");
                    }
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
                
            }		
	}
}
