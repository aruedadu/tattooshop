package co.com.ceiba.tattooshop.infraestructure.controller.peticiones;

import java.io.Serializable;
import java.util.Date;

public class CrearCitaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075426439124835229L;

	private Date fechaInicio;
	private int duracion;
	private String artistaId;
	private String terceroNumeroId;
	
	public CrearCitaRequest() {
	}

	public CrearCitaRequest(Date fechaInicio, int duracion, String artistaId, String terceroNumeroId) {
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.artistaId = artistaId;
		this.terceroNumeroId = terceroNumeroId;
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

	public String getArtistaId() {
		return artistaId;
	}

	public void setArtistaId(String artistaId) {
		this.artistaId = artistaId;
	}

	public String getTerceroNumeroId() {
		return terceroNumeroId;
	}

	public void setTerceroNumeroId(String terceroNumeroId) {
		this.terceroNumeroId = terceroNumeroId;
	}

}
