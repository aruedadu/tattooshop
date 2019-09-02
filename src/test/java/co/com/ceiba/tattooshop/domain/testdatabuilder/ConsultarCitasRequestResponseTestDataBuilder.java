package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.util.List;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.infraestructure.controller.respuestas.ConsultarCitasRequestResponse;

public class ConsultarCitasRequestResponseTestDataBuilder {

	private String cedulaCliente;
	private List<Appointment> citas;

	public ConsultarCitasRequestResponseTestDataBuilder withCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
		return this;
	}

	public List<Appointment> getCitas() {
		return citas;
	}

	public void setCitas(List<Appointment> citas) {
		this.citas = citas;
	}

	public ConsultarCitasRequestResponse build() {
		ConsultarCitasRequestResponse objeto = new ConsultarCitasRequestResponse();
		objeto.setCedulaCliente(this.cedulaCliente);
		return objeto;
	}
}
