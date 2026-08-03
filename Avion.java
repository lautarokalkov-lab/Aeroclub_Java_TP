public class Avion {
    private int id;
    private String modelo;
    private String matricula;
    private double precio_hora;
    private String estado;

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getPrecio_hora() {
		return precio_hora;
	}
	public void setPrecio_hora(double precio_hora) {
		this.precio_hora = precio_hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
