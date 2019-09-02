package co.com.ceiba.tattooshop.domain.integration;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.service.ArtistaService;
import co.com.ceiba.tattooshop.infraestructure.db.ArtistRepositoryImpl;
import co.com.ceiba.tattooshop.infraestructure.db.jpa.ArtistaRepositoryJPA;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistaServiceIntegrationTest {

	@Autowired
	private ArtistaRepositoryJPA repositorioJpa;

	@Autowired
	private ModelMapper mapper;

	@Test
	public void cantidadArtistasDisponibleTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 16, 9, 0);
		int duracion = 3;
		ArtistRepositoryImpl repositorio = new ArtistRepositoryImpl(repositorioJpa, mapper);
		ArtistaService servicio = new ArtistaService(repositorio);

		// act
		List<Artist> artistasEncontrados = servicio.consultarArtistasDisponibles(startDate, duracion);

		// assert
		assertTrue(2 == artistasEncontrados.size());

	}

}
