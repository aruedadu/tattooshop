package co.com.ceiba.tattooshop.infraestructure.db;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;
import co.com.ceiba.tattooshop.infraestructure.db.jpa.CitaRepositoryJPA;
import co.com.ceiba.tattooshop.infraestructure.entity.AppointmentEntity;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

	@Autowired
	private CitaRepositoryJPA repositorio;
	
	@Autowired
	private ModelMapper mapper;
	
	public AppointmentRepositoryImpl(CitaRepositoryJPA repositorio, ModelMapper mapper) {
		this.repositorio = repositorio;
		this.mapper = mapper;
	}

	@Override
	public void guardarCita(Appointment cita) {
		repositorio.save(mapper.map(cita, AppointmentEntity.class));
	}

	@Override
	public void cancelarCita(Appointment cita) {
		repositorio.delete(mapper.map(cita, AppointmentEntity.class));
	}

	@Override
	public Appointment consultarCita(String cedulaTercero, LocalDateTime fechaCita) {
//		AppointmentEntity entidadCita = repositorio.consultarPorCedulaTerceroYFecha(cedulaTercero, fechaCita);
//		return mapper.map(entidadCita, Appointment.class);
		return null;
	}

	@Override
	public List<LocalDateTime> consultarTodasLasCitas(String cedulaTercero) {
		ArrayList<AppointmentEntity> listaCitas = (ArrayList<AppointmentEntity>) repositorio.findAll();
		List<LocalDateTime> fechasCitas = new ArrayList<>();
		for (AppointmentEntity cita : listaCitas) {
			fechasCitas.add(cita.getStartDate());
		}
		return fechasCitas;
	}

}
