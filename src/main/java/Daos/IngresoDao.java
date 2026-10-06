package Daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class IngresoDao {
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
    
    
    public int acceder(String user, String contra) {
    	String sql ="select id_usuario from usuario where email = ? and contraseña = ?";
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		try (
    				Connection conexion = DriverManager.getConnection(url, usuarioSql, contraseñaSql);
    				
    				PreparedStatement sentencia = conexion.prepareStatement(sql)
    				){
    			sentencia.setString(1, user);
    			sentencia.setString(2, contra);
    			
    			ResultSet resultado = sentencia.executeQuery(); 
    			//ResultSet es el tipo de dato para una tabla de sql
    			
    			if (resultado.next()) { //avanza a la pirmera fila
    				
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
