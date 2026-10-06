package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlquilerVista {

    private String modelo;
    private String matricula;

    private LocalDate fechaInicio;

    private LocalTime horaInicio;
    private int horasVuelo;

    private double costoTotal;
    private String estado;
    
    
    
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
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHorasVuelo() {
		return horasVuelo;
	}
	public void setHorasVuelo(int horasVuelo) {
		this.horasVuelo = horasVuelo;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}