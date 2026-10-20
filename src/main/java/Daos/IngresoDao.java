package Daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Clases.Conexion;


public class IngresoDao {
	Conexion conection = new Conexion();
    
    
    public int acceder(String user, String contra) {
    	String sql ="select id_usuario from usuario where email = ? and contraseña = ?";
    	
    	try {
    		Class.forName(conection.getDriver());
    		
    		try (
    				Connection conexion = conection.conectar();
                    PreparedStatement sentencia = conexion.prepareStatement(sql)
    				){
    			sentencia.setString(1, user);
    			sentencia.setString(2, contra);
    			
    			ResultSet resultado = sentencia.executeQuery(); 
    			//ResultSet = tipo de dato para una tabla de sql
    			
    			if (resultado.next()) {
    				
    				int id = resultado.getInt("id_usuario");
    				
    				return id;
    			}
    		}
    		
    	} catch (Exception e) {

            e.printStackTrace();
    		
    	}
    	return 0;
    }

}
