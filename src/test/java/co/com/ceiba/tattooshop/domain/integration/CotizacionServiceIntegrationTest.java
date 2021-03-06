package co.com.ceiba.tattooshop.domain.integration;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	
	private static final String API_GENERAR_COTIZACION = "/tattooshop/cotizacion/generar";
	private static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm";

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void hacerCotizacionSinValorAdicionalTest() throws ParseException {
		//'05/09/2019 10:00', 'dd/MM/yyyy HH:mm'
		// arrange
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 10:00")).withDuracion(3)
				.build();

		// act
		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL(API_GENERAR_COTIZACION),
				HttpMethod.POST, entity, Quotation.class);

		// assert
		assertTrue((450000 == response.getBody().getTotalQuotationValue()));

	}
	
	@Test
	public void hacerCotizacionValorAdicionalAntes8Test() throws ParseException {
		//arrange
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 19:00")).withDuracion(3)
				.build();

		// act
		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL(API_GENERAR_COTIZACION),
				HttpMethod.POST, entity, Quotation.class);
		
		//assert
		assertTrue((472500 == response.getBody().getTotalQuotationValue()));
		
	}
	
	@Test
	public void hacerCotizacionValorAdicionalDespues8Test() throws ParseException {
		//arrange
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 20:00")).withDuracion(3)
				.build();

		// act
		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL(API_GENERAR_COTIZACION),
				HttpMethod.POST, entity, Quotation.class);
		
		//Se espera tener un valor de 495000, dado el calculo hecho a mano
		
		//assert
		assertTrue((495000 == response.getBody().getTotalQuotationValue()));
		
	}

}
