package co.com.ceiba.tattooshop.infraestructure.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository{

	@Override
	public void guardarCita(Appointment cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarCita(Appointment cita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment consultarCita(String cedulaTercero, LocalDateTime fechaCita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalDateTime> consultarTodasLasCitas(String cedulaTercero) {
		// TODO Auto-generated method stub
		return null;
	}

}
