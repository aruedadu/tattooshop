package co.com.ceiba.tattooshop.domain.integration;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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
import org.springframework.web.client.HttpClientErrorException;

import co.com.ceiba.tattooshop.domain.model.Appointment;
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
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private String crearURL(String uri) {
		return "http://localhost:" + port + uri;
	}

//	@Test
//	public void hacerCotizacionSinValorAdicionalTest() throws ParseException {
//		//'05/09/2019 10:00', 'dd/MM/yyyy HH:mm'
//		// arrange
//		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 10:00")).withDuracion(3)
//				.build();
//
//		// act
//		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
//		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
//				HttpMethod.POST, entity, Quotation.class);
//
//		// assert
//		assertTrue((450000 == response.getBody().getTotalQuotationValue()));
//
//	}
//	
//	@Test
//	public void hacerCotizacionValorAdicionalAntes8Test() {
//		//arrange
//		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 19:00")).withDuracion(3)
//				.build();
//
//		// act
//		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
//		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
//				HttpMethod.POST, entity, Quotation.class);
//		
//		//assert
//		assertTrue((472500==quotation.getTotalQuotationValue()));
//		
//	}
//	
//	@Test
//	public void hacerCotizacionValorAdicionalDespues8Test() {
//		//arrange
//		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("05/09/2019 20:00")).withDuracion(3)
//				.build();
//
//		// act
//		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
//		ResponseEntity<Quotation> response = restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
//				HttpMethod.POST, entity, Quotation.class);
//		
//		//Se espera tener un valor de 495000, dado el calculo hecho a mano
//		
//		//assert
//		assertTrue((495000==quotation.getTotalQuotationValue()));
//		
//	}
	
	@Test
	public void hacerCotizacionDiaNoServicioTest() throws ParseException {
		//arrange
		CotizacionRequest request = new CotizacionRequestDataBuilder().withFechaInicio(sdf.parse("08/09/2019 10:00")).withDuracion(3)
				.build();
		HttpEntity<CotizacionRequest> entity = new HttpEntity<>(request, headers);
		try {
			ResponseEntity<Quotation> response =  restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
					HttpMethod.POST, entity, Quotation.class);
			int status = response.getStatusCodeValue();
			System.err.println(response.getStatusCode().getReasonPhrase());
			
		}catch (Exception e) {
			System.err.println("********************************");
			System.err.println("********************************");
			System.err.println("********************************");
			System.err.println("********************************");
			e.printStackTrace();
			System.err.println("********************************");
			System.err.println("********************************");
			System.err.println("********************************");
			System.err.println("********************************");
			System.err.println("********************************");
		}
		
		//act -assert
		assertThatExceptionOfType(HttpClientErrorException.class).isThrownBy(() -> 
		restTemplate.exchange(crearURL("/tattooshop/cotizacion/generar"),
				HttpMethod.POST, entity, Quotation.class)
		).withMessageMatching("Los Domingos no hay servicio!");
	}

}
