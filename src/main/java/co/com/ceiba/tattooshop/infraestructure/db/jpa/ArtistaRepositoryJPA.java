package co.com.ceiba.tattooshop.infraestructure.db.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.tattooshop.infraestructure.entity.ArtistEntity;

public interface ArtistaRepositoryJPA extends JpaRepository<ArtistEntity, Long> {

	@Query("SELECT a FROM ArtistEntity a WHERE a.id NOT IN (SELECT p.artist.id FROM AppointmentEntity p WHERE (p.startDate BETWEEN :FECHA_INI AND :FECHA_FIN)"
			+ " OR (p.endDate BETWEEN :FECHA_INI AND :FECHA_FIN))")
	List<ArtistEntity> consultarArtistasDisponibles(@Param(value = "FECHA_INI") LocalDateTime fechaCita,
			@Param(value = "FECHA_FIN") LocalDateTime fechaFinCita);

}
