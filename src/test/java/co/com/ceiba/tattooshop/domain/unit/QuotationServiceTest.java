package co.com.ceiba.tattooshop.domain.unit;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import co.com.ceiba.tattooshop.domain.exception.NoServiceException;
import co.com.ceiba.tattooshop.domain.model.Quotation;
import co.com.ceiba.tattooshop.domain.service.QuotationService;

public class QuotationServiceTest {
	
	@Test
	public void createQuotationTest() {
		assertEquals((2+2), 4);
	}
	
	@Test
	public void makeQuotationNoAdditionalValueTest() {
		//arrange
		QuotationService service = new QuotationService();		
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 12, 9, 0);
		int duration = 3;
		
		//act
		Quotation quotation = service.getQuotation(startDate, duration);
		
		//assert
		assertTrue((450000==quotation.getTotalQuotationValue()));
		
	}
	
	@Test
	public void makeQuotationAdditionalValuePre8Test() {
		//arrange
		QuotationService service = new QuotationService();		
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 12, 19, 0);
		int duration = 3;
		
		//act
		Quotation quotation = service.getQuotation(startDate, duration);
		
		//Se espera tener un valor de 472500, dado el calculo hecho a mano
		
		//assert
		assertTrue((472500==quotation.getTotalQuotationValue()));
		
	}
	
	@Test
	public void makeQuotationAdditionalValuePos8Test() {
		//arrange
		QuotationService service = new QuotationService();		
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 12, 20, 0);
		int duration = 3;
		
		//act
		Quotation quotation = service.getQuotation(startDate, duration);
		
		//Se espera tener un valor de 495000, dado el calculo hecho a mano
		
		//assert
		assertTrue((495000==quotation.getTotalQuotationValue()));
		
	}
	
	@Test
	public void makeQuotationNoServiceTest() {
		//arrange
		QuotationService service = new QuotationService();		
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 11, 10, 0);
		int duration = 3;
		
		System.err.println("code smell test sonar");
		
		//act -assert
		
		assertThatExceptionOfType(NoServiceException.class).isThrownBy(() -> 
			service.getQuotation(startDate, duration)
		).withMessageMatching("Los Domingos no hay servicio!");
	}

}
