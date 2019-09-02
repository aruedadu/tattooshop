package co.com.ceiba.tattooshop.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository repoAppointment;
	
	public AppointmentService(AppointmentRepository repoAppointment) {
		this.repoAppointment = repoAppointment;
	}

	public void crearCita(Appointment appointment) {
		repoAppointment.guardarCita(appointment);
	}

	public void cancelarCita(Appointment appointment) {
		repoAppointment.cancelarCita(appointment);
	}

	public List<Appointment> consultarTodasLasCitas(String cedulaTercero) {
		return repoAppointment.consultarTodasLasCitas(cedulaTercero);
	}
}
