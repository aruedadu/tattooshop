package co.com.ceiba.tattooshop.infraestructure.db;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.repository.ArtistRepository;
import co.com.ceiba.tattooshop.infraestructure.db.jpa.ArtistaRepositoryJPA;
import co.com.ceiba.tattooshop.infraestructure.entity.ArtistEntity;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository {

	@Autowired
	private ArtistaRepositoryJPA repositorio;

	@Autowired
	private ModelMapper mapper;

	public ArtistRepositoryImpl(ArtistaRepositoryJPA repositorio, ModelMapper mapper) {
		super();
		this.repositorio = repositorio;
		this.mapper = mapper;
	}

	@Override
	public List<Artist> consultarArtistasDisponibles(LocalDateTime fechaCita, LocalDateTime fechaFinCita) {
		List<ArtistEntity> listaArtistasEntidad = repositorio.consultarArtistasDisponibles(fechaCita, fechaFinCita);
		List<Artist> artistas = new ArrayList<>();
		for (ArtistEntity entidad : listaArtistasEntidad) {
			artistas.add(new Artist(
					entidad.getId(),
					entidad.getArtistFullName(),
					entidad.getArtistIdNumber()
			));
		}
		return artistas;
	}

}
