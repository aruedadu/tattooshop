package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.util.Date;

import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CrearCitaRequest;

public class CitaRequestTestDataBuilder {

	private Date fechaInicio;
	private int duracion;
	private String artistaId;
	private String terceroNumeroId;

	public CitaRequestTestDataBuilder withFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public CitaRequestTestDataBuilder withDuracion(int duracion) {
		this.duracion = duracion;
		return this;
	}

	public CitaRequestTestDataBuilder withArtistaId(String artistaId) {
		this.artistaId = artistaId;
		return this;
	}

	public CitaRequestTestDataBuilder withTerceroNumeroId(String terceroNumeroId) {
		this.terceroNumeroId = terceroNumeroId;
		return this;
	}

	public CrearCitaRequest build() {
		return new CrearCitaRequest(this.fechaInicio, this.duracion, this.artistaId, this.terceroNumeroId);
	}

}
