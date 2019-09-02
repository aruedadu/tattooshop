package co.com.ceiba.tattooshop.domain.integration;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.testdatabuilder.AppointmentTestDataBuilder;
import co.com.ceiba.tattooshop.domain.testdatabuilder.CitaRequestTestDataBuilder;
import co.com.ceiba.tattooshop.domain.testdatabuilder.ConsultarCitasRequestResponseTestDataBuilder;
import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CrearCitaRequest;
import co.com.ceiba.tattooshop.infraestructure.controller.respuestas.ConsultarCitasRequestResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitaServiceIntegrationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final String CEDULA_CLIENTE = "1017159532";
	private static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm";

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void consultarCitasTest() {
		// arrange
		ConsultarCitasRequestResponse request = new ConsultarCitasRequestResponseTestDataBuilder()
				.withCedulaCliente(CEDULA_CLIENTE).build();
		HttpEntity<ConsultarCitasRequestResponse> entity = new HttpEntity<>(request, headers);

		// act
		ResponseEntity<ConsultarCitasRequestResponse> response = restTemplate.exchange(
				crearURL("/tattooshop/appointment/consultar-todas-citas"), HttpMethod.POST, entity,
				ConsultarCitasRequestResponse.class);

		List<Appointment> citas = response.getBody().getCitas();

		// assert
		assertTrue(!citas.isEmpty());

	}

	@Test
	public void saveAppointmentTestService() throws ParseException {
		// arrange
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		CrearCitaRequest request = new CitaRequestTestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 10:00"))
				.withDuracion(3).withArtistaId("1").withTerceroNumeroId(CEDULA_CLIENTE).build();

		HttpEntity<CrearCitaRequest> entity = new HttpEntity<>(request, headers);

		// act
		ResponseEntity<Appointment> response = restTemplate.exchange(crearURL("/tattooshop/appointment/crear-cita"),
				HttpMethod.POST, entity, Appointment.class);

		int status = response.getStatusCodeValue();
		// assert
		assertTrue(status == 200);
	}

	@Test
	public void deleteAppointmentTest() {
		// arrange
		Appointment appointment = new AppointmentTestDataBuilder().withId(1).buildWithId();

		HttpEntity<Appointment> entity = new HttpEntity<>(appointment, headers);

		// act
		ResponseEntity<Appointment> response = restTemplate.exchange(crearURL("/tattooshop/appointment/cancelar-cita"),
				HttpMethod.POST, entity, Appointment.class);

		int status = response.getStatusCodeValue();
		// assert
		assertTrue(status == 200);

	}
}
