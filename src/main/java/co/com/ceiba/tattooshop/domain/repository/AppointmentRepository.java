package co.com.ceiba.tattooshop.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.tattooshop.domain.model.Appointment;

@Component
public interface AppointmentRepository {
	
	public void guardarCita(Appointment cita);
	public void cancelarCita(Appointment cita);
	public Appointment consultarCita(String cedulaTercero, LocalDateTime fechaCita);
	public List<LocalDateTime> consultarTodasLasCitas(String cedulaTercero);

}
