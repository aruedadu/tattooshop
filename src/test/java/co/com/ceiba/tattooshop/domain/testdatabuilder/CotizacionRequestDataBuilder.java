package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.util.Date;

import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CotizacionRequest;

public class CotizacionRequestDataBuilder {

	private Date fechaInicio;
	private int duracion;

	public CotizacionRequestDataBuilder withFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public CotizacionRequestDataBuilder withDuracion(int duracion) {
		this.duracion = duracion;
		return this;
	}

	public CotizacionRequest build() {
		return new CotizacionRequest(this.fechaInicio, this.duracion);
	}

}
