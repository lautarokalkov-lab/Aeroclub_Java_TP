package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Clases.Conexion;
import Clases.Usuario;

public class RegistroDao {

	Conexion conection = new Conexion();

    public boolean registrar(Usuario user) {

        String sql =
            "INSERT INTO usuario " +
            "(email, contraseña, apellido, nombre, nro_doc, domicilio, telefono) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName(conection.getDriver());
            try (
            	Connection conexion = conection.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
            ) {
                sentencia.setString(1, user.getEmail());
                sentencia.setString(2, user.getContraseña());
                sentencia.setString(3, user.getApellido());
                sentencia.setString(4, user.getNombre());
                sentencia.setString(5, user.getNro_doc());
                sentencia.setString(6, user.getDomicilio());
                sentencia.setString(7, user.getTelefono());

                int filas = sentencia.executeUpdate();

                return filas > 0; //si hay alguna fila devuelve true
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean existeEmail(String email) {

        String sql =
            "SELECT id_usuario FROM usuario WHERE email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                Connection conexion = DriverManager.getConnection(conection.getUrl(), conection.getUsuarioSql(), conection.getContraseñaSql());

                PreparedStatement sentencia = conexion.prepareStatement(sql)) {

                sentencia.setString(1, email);
                ResultSet resultado = sentencia.executeQuery();
                return resultado.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}