package co.com.ceiba.tattooshop.infraestructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.tattooshop.infraestructure.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

	public List<AppointmentEntity> getAppointmentByThirdIdNumber(String thirdIdNumber);

}
