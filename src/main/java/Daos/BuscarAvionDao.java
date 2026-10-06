package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Clases.AvionDisponible;

public class BuscarAvionDao {
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
    
    public AvionDisponible buscarAvion(String idAvion) {
    	
    		String sql =
    			"select id_avion, modelo, matricula, precio_hora from avion " +
    			"where id_avion = ?";

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
                    sentencia.setString(1, idAvion);
                    
                    AvionDisponible avion = new AvionDisponible();
                    ResultSet resultado = sentencia.executeQuery();
                    if (resultado.next()) {
        				
                    	avion.setId(resultado.getInt("id_avion"));
                    	avion.setModelo(resultado.getString("modelo"));
                    	avion.setMatricula(resultado.getString("matricula"));
                    	avion.setPrecio_hora(resultado.getDouble("precio_hora"));                   	
        				
        				return avion;
        			}
                }

            } catch (Exception e) {
                e.printStackTrace();
                
            }
            return null;
			
    }
}
