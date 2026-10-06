package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GuardarAlquilerDao {
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
	
	public void Guardar(int idUsuario, int idAvion, String fechaIni, String horaIni, int horasVuelo, double costo) {
		String sql =
				"INSERT INTO alquiler (fecha_inicio, hora_inicio, horasVuelo, estado, costo_total, id_usuario, id_avion)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (
                    Connection conexion = DriverManager.getConnection(
                        url,
                        usuarioSql,
                        contraseñaSql
                    );
                    PreparedStatement sentencia = conexion.prepareStatement(sql)
                ) {
                    sentencia.setString(1, fechaIni);
                    sentencia.setString(2, horaIni);
                    sentencia.setInt(3, horasVuelo);
                    sentencia.setString(4, "Pendiente");
                    sentencia.setDouble(5, costo);
                    sentencia.setInt(6, idUsuario);
                    sentencia.setInt(7, idAvion);

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
