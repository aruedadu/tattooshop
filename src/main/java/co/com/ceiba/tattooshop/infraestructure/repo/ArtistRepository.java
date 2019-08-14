package co.com.ceiba.tattooshop.infraestructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ceiba.tattooshop.infraestructure.entity.ArtistEntity;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

	@Query("SELECT a FROM ArtistEntity a")
	public List<ArtistEntity> getArtist();

}
