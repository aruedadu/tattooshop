package co.com.ceiba.tattooshop.infraestructure.db.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import co.com.ceiba.tattooshop.infraestructure.entity.AppointmentEntity;

@Component
public interface CitaRepositoryJPA extends JpaRepository<AppointmentEntity, Long> {

	@Query("SELECT p FROM AppointmentEntity p WHERE p.thirdIdNumber = :thirdIdNumber AND p.startDate = :startDate")
	AppointmentEntity consultarPorCedulaTerceroYFecha(@Param(value = "thirdIdNumber") String cedulaTercero,
			@Param(value = "startDate") LocalDateTime fechaCita);
	

}
