package co.com.ceiba.tattooshop.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.infraestructure.entity.AppointmentEntity;
import co.com.ceiba.tattooshop.infraestructure.repo.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repoAppointment;
	
	@Autowired
	private ModelMapper mapper;
	
	public void createAppointmet(Appointment appointment) {
		
		AppointmentEntity entity = mapper.map(appointment, AppointmentEntity.class);
		repoAppointment.save(entity);
		
	}
	

}
