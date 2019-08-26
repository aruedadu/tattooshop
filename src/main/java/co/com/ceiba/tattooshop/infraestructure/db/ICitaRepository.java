package co.com.ceiba.tattooshop.infraestructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;

public interface ICitaRepository extends AppointmentRepository, JpaRepository<AppointmentRepository, Long> {

}
