package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";
    private String driver = "com.mysql.cj.jdbc.Driver";
    
	public String getUrl() {
		return url;
	}
	public String getUsuarioSql() {
		return usuarioSql;
	}
	public String getContraseñaSql() {
		return contraseñaSql;
	}
	
	public String getDriver() {
		return driver;
	}
	
	public Connection conectar() throws SQLException {
		
        return DriverManager.getConnection(url, usuarioSql, contraseñaSql);        
    }
    
    
}
