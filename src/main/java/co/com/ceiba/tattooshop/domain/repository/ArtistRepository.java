package co.com.ceiba.tattooshop.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.tattooshop.domain.model.Artist;

public interface ArtistRepository {

	public List<Artist> consultarArtistasDisponibles(LocalDateTime fechaCita, LocalDateTime fechaFinCita);

}
