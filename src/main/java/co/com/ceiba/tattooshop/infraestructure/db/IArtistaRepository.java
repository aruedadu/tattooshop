package co.com.ceiba.tattooshop.infraestructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.tattooshop.domain.repository.ArtistRepository;
import co.com.ceiba.tattooshop.infraestructure.entity.ArtistEntity;

public interface IArtistaRepository extends ArtistRepository, JpaRepository<ArtistEntity, Long> {

}
