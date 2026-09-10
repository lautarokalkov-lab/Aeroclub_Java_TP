import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alquiler {
    private int id;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    private double precio;

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(LocalDateTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public LocalDateTime getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(LocalDateTime hora_fin) {
		this.hora_fin = hora_fin;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
    
}
