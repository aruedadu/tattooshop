package co.com.ceiba.tattooshop.infraestructure.controller.respuestas;

import java.io.Serializable;
import java.util.List;

import co.com.ceiba.tattooshop.domain.model.Appointment;

public class ConsultarCitasRequestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3192956065586854811L;
	private String cedulaCliente;
	private List<Appointment> citas;

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public List<Appointment> getCitas() {
		return citas;
	}

	public void setCitas(List<Appointment> citas) {
		this.citas = citas;
	}

}
