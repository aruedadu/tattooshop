package co.com.ceiba.tattooshop.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repoAppointment;
	
	public void createAppointmet(Appointment appointment) {
		
		repoAppointment.guardarCita(appointment);
		
	}
	

}
