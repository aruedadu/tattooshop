package co.com.ceiba.tattooshop.infraestructure.controller.peticiones;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CotizacionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2227360870668674891L;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date fechaInicio;
	private int duracion;

	public CotizacionRequest(Date fechaInicio, int duracion) {
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
	}

	public CotizacionRequest() {
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
