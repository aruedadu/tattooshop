package co.com.ceiba.tattooshop.domain.integration;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

import co.com.ceiba.tattooshop.domain.model.Quotation;
import co.com.ceiba.tattooshop.domain.testdatabuilder.CotizacionRequestDataBuilder;
import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CotizacionRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CotizacionServiceIntegrationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void makeQuotationNoAdditionalValueTest() throws ParseException {
		// arrange
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getDefault());
		Date fechaInicio = sdf.parse("2019-08-27 12:00");
		CotizacionRequest cotizacion = new CotizacionRequestDataBuilder().withFechaInicio(fechaInicio).withDuracion(3)
				.build();

		// act
		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(cotizacion, headers);
		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
				HttpMethod.POST, entity, Quotation.class);

		// assert
		assertTrue((450000 == response.getBody().getTotalQuotationValue()));

	}

}
