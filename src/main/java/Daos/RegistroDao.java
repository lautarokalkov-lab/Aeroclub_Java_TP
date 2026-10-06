package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroDao {

    private String url = "jdbc:mysql://localhost:3306/aeroclub";
    private String usuarioSql = "root";
    private String contraseñaSql = "root";

    public boolean registrar(
            String email,
            String contrasena,
            String apellido,
            String nombre,
            String documento,
            String direccion,
            String telefono) {

        String sql =
            "INSERT INTO usuario " +
            "(email, contraseña, apellido, nombre, nro_doc, domicilio, telefono) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                Connection conexion = DriverManager.getConnection(
                    url,
                    usuarioSql,
                    contraseñaSql
                );
                PreparedStatement sentencia =
                    conexion.prepareStatement(sql)
            ) {
                sentencia.setString(1, email);
                sentencia.setString(2, contrasena);
                sentencia.setString(3, apellido);
                sentencia.setString(4, nombre);
                sentencia.setString(5, documento);
                sentencia.setString(6, direccion);
                sentencia.setString(7, telefono);

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
                Connection conexion = DriverManager.getConnection(
                    url, usuarioSql, contraseñaSql
                );

                PreparedStatement sentencia =
                    conexion.prepareStatement(sql)
            ) {

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