package co.com.ceiba.tattooshop.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.repository.ArtistRepository;

@Service
public class ArtistaService {
	

	@Autowired
	ArtistRepository repositorio;
	
	public ArtistaService(ArtistRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	public List<Artist> consultarArtistasDisponibles(LocalDateTime fechaCita, int duracion){
		LocalDateTime fechaFinCita = fechaCita.plusHours(duracion);
		return repositorio.consultarArtistasDisponibles(fechaCita, fechaFinCita);
	}

}
