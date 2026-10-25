package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import Clases.Conexion;
import Clases.Curso;

public class CursosDao {
	
	Conexion conection = new Conexion();
	
	public LinkedList<Curso> listarCursos(int idUsuario) {
		LinkedList<Curso> cursos = new LinkedList<>();
		String sql = "select curso.id_curso, curso.nombre, curso.duracion, curso.horas_vuelo, curso.costo, tipo_licencia.nombre as licencia, curso.descripcion from curso "
				+ "left join tipo_licencia on tipo_licencia.id_tipo_licencia = curso.id_tipo_licencia "
				+ "left join inscripcion on inscripcion.id_curso = curso.id_curso and inscripcion.id_usuario = ? "
				+ "where  isnull(inscripcion.estado)";
		
		try {
	        Class.forName(conection.getDriver());

	        try (
	        		Connection conexion = conection.conectar();
                    PreparedStatement sentencia = conexion.prepareStatement(sql)
	        ) {

	            sentencia.setInt(1, idUsuario);
	            ResultSet resultado = sentencia.executeQuery();

	            while (resultado.next()) {
	                Curso curso = new Curso();
	                curso.setIdCurso(resultado.getInt("id_curso"));
	                curso.setIdUsuario(idUsuario);
	                curso.setNombre(resultado.getString("nombre"));
	                curso.setDuracion(resultado.getString("Duracion"));
	                curso.setHorasVuelo(resultado.getInt("horas_vuelo"));
	                curso.setCosto(resultado.getDouble("costo"));
	                curso.setLicencia(resultado.getString("licencia"));
	                curso.setDescripcion(resultado.getString("descripcion"));
	                cursos.add(curso);
	            }
	        }
		}catch (Exception e) {
	        e.printStackTrace();
	    }

	    return cursos;
	
	}
	
	public boolean GuardarCurso(int idUsuario, int idCurso) {
		
		String sql = "INSERT INTO inscripcion " +
	            "(id_curso, id_usuario, fecha_inscripcion, estado) " +
	            "VALUES (?, ?, CURDATE(), 'Inscripto')";
		try {
	        Class.forName(conection.getDriver());

	        try (
	        		Connection conexion = conection.conectar();
                    PreparedStatement sentencia = conexion.prepareStatement(sql)
	        ) {
	            sentencia.setInt(1, idCurso);
	            sentencia.setInt(2, idUsuario);
	            int filas = sentencia.executeUpdate();
	            return filas >0;
	        }
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
}
