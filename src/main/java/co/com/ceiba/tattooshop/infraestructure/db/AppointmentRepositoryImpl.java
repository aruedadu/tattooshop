package co.com.ceiba.tattooshop.infraestructure.db;

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
	public List<Appointment> consultarTodasLasCitas(String cedulaTercero) {
		ArrayList<AppointmentEntity> listaCitas = (ArrayList<AppointmentEntity>) repositorio.consultarCitasTercero(cedulaTercero);
		List<Appointment> citas = new ArrayList<>();
		for (AppointmentEntity cita : listaCitas) {
			citas.add(mapper.map(cita, Appointment.class));
		}
		return citas;
	}

}
