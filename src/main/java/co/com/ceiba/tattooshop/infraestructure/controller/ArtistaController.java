package co.com.ceiba.tattooshop.infraestructure.controller;

import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.service.ArtistaService;
import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CotizacionRequest;

@CrossOrigin
@RestController
@RequestMapping(value = "/tattooshop/artistas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArtistaController {

	@Autowired
	ArtistaService servicio;

	@PostMapping(value = "/consultar-artistas-disponibles")
	public @ResponseBody List<Artist> consultarArtistasDisponibles(@RequestBody CotizacionRequest payload) {
		
		System.err.println("holi");
		
		return servicio.consultarArtistasDisponibles(payload.getFechaInicio().toInstant().atZone(ZoneId.from(new TemporalAccessor() {
			
			@Override
			public boolean isSupported(TemporalField field) {
				return true;
			}
			
			@Override
			public long getLong(TemporalField field) {
				return 0;
			}
		})).toLocalDateTime(),
		payload.getDuracion());
	}

}
