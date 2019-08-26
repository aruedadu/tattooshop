package co.com.ceiba.tattooshop.infraestructure.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.repository.ArtistRepository;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository{

	@Override
	public List<Artist> consultarArtistasDisponibles(LocalDateTime fechaCita, int duracion) {
		// TODO Auto-generated method stub
		return null;
	}

}
