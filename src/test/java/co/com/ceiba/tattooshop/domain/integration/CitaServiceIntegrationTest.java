package co.com.ceiba.tattooshop.domain.integration;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.service.AppointmentService;
import co.com.ceiba.tattooshop.domain.testdatabuilder.AppointmentTestDataBuilder;
import co.com.ceiba.tattooshop.domain.testdatabuilder.ArtistTestDataBuilder;
import co.com.ceiba.tattooshop.infraestructure.db.AppointmentRepositoryImpl;
import co.com.ceiba.tattooshop.infraestructure.db.jpa.CitaRepositoryJPA;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitaServiceIntegrationTest {

	@Autowired
	private CitaRepositoryJPA repositorio;

	@Autowired
	private ModelMapper mapper;

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final String CEDULA_ARTISTA = "1037604310";
	private static final String NOMBRE_ARTISTA = "Alejandro Rueda";
	private static final String CEDULA_CLIENTE = "101612355";

	@Test
	public void saveAppointmentTestService() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 9, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 12, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber(CEDULA_ARTISTA)
				.withArtistFullName(NOMBRE_ARTISTA).build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).withThirdIdNumber(CEDULA_CLIENTE).build();

		HttpEntity<Appointment> entity = new HttpEntity<>(appointment, headers);
		ResponseEntity<Appointment> response = restTemplate.exchange(crearURL("/tattooshop/appointment/crear-cita"),
				HttpMethod.POST, entity, Appointment.class);
		int status = response.getStatusCodeValue();
		assertTrue(status == 200);

	}

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void deleteAppointmentTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 13, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 15, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber(CEDULA_ARTISTA)
				.withArtistFullName(NOMBRE_ARTISTA).build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).withThirdIdNumber(CEDULA_CLIENTE).withId(1).buildWithId();

		AppointmentRepositoryImpl repository = new AppointmentRepositoryImpl(repositorio, mapper);

		AppointmentService service = new AppointmentService(repository);

		// act - assert
		service.cancelarCita(appointment);

	}

	@Test
	public void saveAppointmentTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 13, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 15, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber(CEDULA_ARTISTA)
				.withArtistFullName(NOMBRE_ARTISTA).build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).withThirdIdNumber(CEDULA_CLIENTE).build();

		AppointmentRepositoryImpl repository = new AppointmentRepositoryImpl(repositorio, mapper);

		AppointmentService service = new AppointmentService(repository);

		// act - assert
		service.crearCita(appointment);

	}
}
