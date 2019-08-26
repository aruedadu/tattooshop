package co.com.ceiba.tattooshop.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Artist;

@Service
public class ArtistaService {
	
	@Autowired
	ArtistaService servicio;
	
	public List<Artist> consultarArtistasDisponibles(LocalDateTime fechaCita, int duracion){
		return servicio.consultarArtistasDisponibles(fechaCita, duracion);
	}

}
