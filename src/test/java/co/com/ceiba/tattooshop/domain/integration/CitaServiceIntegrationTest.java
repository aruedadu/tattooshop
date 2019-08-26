package co.com.ceiba.tattooshop.domain.integration;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

//	@LocalServerPort
//    private int port;
//
//	TestRestTemplate restTemplate = new TestRestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//
//	@Test
//	public void saveAppointmentTest() {
//
//		// arrange
//		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 9, 0);
//		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 12, 0);
//		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber("1037604310")
//				.withArtistFullName("Alejandro Rueda").build();
//		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
//				.withTattooArtist(artist).withThirdIdNumber("101612355").build();
//
//		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
//		ResponseEntity<Appointment> response = restTemplate.exchange(crearURL("/tattooshop/appointment/crear-cita"),
//				HttpMethod.POST, entity, Appointment.class);
//		//String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//		int status = response.getStatusCodeValue();
//		//System.err.println("actual " + actual);
//		//assertTrue(actual.contains("/students"));
//		System.err.println("actual " + status);
//		assertTrue(status == 200);
//
//	}
//
//	private String crearURL(String uri) {
//		System.err.println("http://localhost:" + port + uri);
//		return "http://localhost:" + port + uri;
//	}

	@Test
	public void deleteAppointmentTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 9, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 12, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber("1037604310")
				.withArtistFullName("Alejandro Rueda").build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).withThirdIdNumber("101612355").withId(1).buildWithId();

		AppointmentRepositoryImpl repository = new AppointmentRepositoryImpl(repositorio, mapper);

		AppointmentService service = new AppointmentService(repository);

		// act - assert
		service.cancelarCita(appointment);

	}


	@Test
	public void saveAppointmentTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 9, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 12, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber("1037604310")
				.withArtistFullName("Alejandro Rueda").build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).withThirdIdNumber("101612355").build();

		System.err.println("cita: " + appointment.toString());

		AppointmentRepositoryImpl repository = new AppointmentRepositoryImpl(repositorio, mapper);

		AppointmentService service = new AppointmentService(repository);

		// act - assert
		service.crearCita(appointment);

	}
}
