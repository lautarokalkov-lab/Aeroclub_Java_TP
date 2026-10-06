package Daos;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import Clases.AvionDisponible;

public class NuevoAlquilerDao {
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
    
    public LinkedList<AvionDisponible> buscarDisponibles(
            int idUsuario,
            String fechaInicio,            
            String horaInicio,
            int horasVuelo,
            String modelo) {

        LinkedList<AvionDisponible> aviones = new LinkedList<>();

        String sql =
        	    "SELECT DISTINCT " +
        	    "avion.id_avion, avion.modelo, avion.matricula, avion.precio_hora " +
        	    "FROM avion " +
        	    "JOIN tipo_avion ON tipo_avion.id_tipo_avion = avion.id_tipo_avion " +
        	    "JOIN licencia_usuario ON licencia_usuario.id_tipo_licencia = tipo_avion.id_tipo_licencia " +
        	    "WHERE avion.estado = 'Activo' " +
        	    "AND licencia_usuario.id_usuario = ? " +
        	    "AND NOT EXISTS ( " +
        	    "    SELECT 1 FROM alquiler " +
        	    "    WHERE alquiler.id_avion = avion.id_avion " +
        	    "    AND TIMESTAMP(alquiler.fecha_inicio, alquiler.hora_inicio) " +
        	    "        < TIMESTAMP(?, ?) " +
        	    "    AND TIMESTAMP(alquiler.fecha_inicio, alquiler.hora_inicio) " +
        	    "        + INTERVAL alquiler.horasVuelo HOUR > TIMESTAMP(?, ?) " +
        	    ") " +
        	    "AND (? = '' OR avion.modelo = ?) " +
        	    "ORDER BY avion.modelo";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                Connection conexion =
                    DriverManager.getConnection(
                        url,
                        usuarioSql,
                        contraseñaSql
                    );

                PreparedStatement sentencia =
                    conexion.prepareStatement(sql)
            ) {
            	sentencia.setInt(1, idUsuario);
            	
            	LocalDateTime inicio = LocalDateTime.of(
            		    LocalDate.parse(fechaInicio),
            		    LocalTime.parse(horaInicio));

            	LocalDateTime fin = inicio.plusHours(horasVuelo);

            	sentencia.setString(2, fin.toLocalDate().toString());
            	sentencia.setString(3, fin.toLocalTime().toString());

            	sentencia.setString(4, fechaInicio);
            	sentencia.setString(5, horaInicio);

            	sentencia.setString(6, modelo);
            	sentencia.setString(7, modelo);

                ResultSet resultado = sentencia.executeQuery();

                while (resultado.next()) {

                    AvionDisponible avion = new AvionDisponible();

                    avion.setId(resultado.getInt("id_avion"));

                    avion.setModelo(resultado.getString("modelo"));

                    avion.setMatricula(resultado.getString("matricula"));

                    avion.setPrecio_hora(resultado.getDouble("precio_hora"));

                    aviones.add(avion);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return aviones;
    }
    
    public LinkedList<String> listarModelos(int idUsuario){
    	
    	LinkedList<String> modelos = new LinkedList<>();
    	
    	 String sql = "SELECT DISTINCT modelo FROM avion " +
    			 "join tipo_avion on tipo_avion.id_tipo_avion = avion.id_tipo_avion " +
    			 "join licencia_usuario on licencia_usuario.id_tipo_licencia = tipo_avion.id_tipo_licencia " +
    			 "WHERE estado = 'Activo' and licencia_usuario.id_usuario = ? " +
    			 "ORDER BY modelo";
    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             try (
                 Connection conexion =
                     DriverManager.getConnection(
                         url,
                         usuarioSql,
                         contraseñaSql
                     );

                 PreparedStatement sentencia = conexion.prepareStatement(sql)
             ) {
            	 sentencia.setInt(1, idUsuario);
                 ResultSet resultado = sentencia.executeQuery();

                 while (resultado.next()) {
                	 modelos.add(resultado.getString("modelo"));
                 }
             }

         } catch (Exception e) {
             e.printStackTrace();
         }
    	 return modelos;
    	 
    	 		
    }
}
