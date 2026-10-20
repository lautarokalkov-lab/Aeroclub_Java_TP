package Daos;

import java.sql.Connection;
import Clases.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Clases.AvionDisponible;

public class BuscarAvionDao {
	Conexion conection = new Conexion();
    
    public AvionDisponible buscarAvion(String idAvion) {
    	
    		String sql =
    			"select id_avion, modelo, matricula, precio_hora from avion " +
    			"where id_avion = ?";

            try {
                Class.forName(conection.getDriver());
                try (
                    Connection conexion = conection.conectar();
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
