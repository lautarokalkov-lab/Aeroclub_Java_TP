package Clases;

public class Alquiler {
    private int id;
    private int idUsuario;
    private int idAvion;
    private String horaInicio;
    private int horasVuelo;
    private String fechaInicio;
    private String estado;
    private double costoTotal;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHorasVuelo() {
		return horasVuelo;
	}
	public void setHorasVuelo(int horasVuelo) {
		this.horasVuelo = horasVuelo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

    
	
    
}
