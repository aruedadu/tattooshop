package co.com.ceiba.tattooshop.infraestructure.db.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;
import co.com.ceiba.tattooshop.infraestructure.db.ICitaRepository;

@Repository
public class ICitaRepositoryImplement implements ICitaRepository{

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

	@Override
	public List<AppointmentRepository> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentRepository> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentRepository> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends AppointmentRepository> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<AppointmentRepository> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AppointmentRepository getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AppointmentRepository> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AppointmentRepository> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AppointmentRepository entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends AppointmentRepository> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends AppointmentRepository> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppointmentRepository> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends AppointmentRepository> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
