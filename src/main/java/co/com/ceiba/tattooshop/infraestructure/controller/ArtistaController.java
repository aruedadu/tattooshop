package co.com.ceiba.tattooshop.infraestructure.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.service.ArtistaService;

@RestController
@RequestMapping(value = "/tattooshop/artistas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArtistaController {

	@Autowired
	ArtistaService servicio;

	@PostMapping(value = "/consultar-artistas-disponibles")
	public @ResponseBody List<Artist> consultarArtistasDisponibles(
			@RequestParam(value = "fechaCita") LocalDateTime fechaCita,
			@RequestParam(value = "duracion") int duracion) {
		return servicio.consultarArtistasDisponibles(fechaCita, duracion);
	}

}
