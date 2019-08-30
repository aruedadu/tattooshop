package co.com.ceiba.tattooshop.domain.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.exception.NoServiceException;
import co.com.ceiba.tattooshop.domain.model.Quotation;

//TODO: VERIFICAR HORA INICIO Y HORA FINAL, NO DEBE PODER ASIGNAR CITAS PREVIAS A LAS 10AM NI POSTERIORES A MEDIA NOCHE, LA HORA DE INICIO NO PUEDE SER PREVIA A LA HORA ACTUAL NI LA FEHCA ACTUAL 
@Service
public class QuotationService {

	private static final DayOfWeek NO_SERVICE_DAY = DayOfWeek.SUNDAY;
	private static final int ADDITIONAL_VALUE_HOUR = 20;

	public Quotation getQuotation(LocalDateTime startDate, int duration) {
		if (startDate.getDayOfWeek() != NO_SERVICE_DAY) {
			LocalDateTime endDate = startDate.plusHours(duration);
			long quotationValue = Quotation.TATTOO_HOUR_VALUE * duration;
			if (startDate.getHour() >= ADDITIONAL_VALUE_HOUR) {
				quotationValue += quotationValue * Quotation.ADDITIONAL_VALUE_POS_8;
			} else if (endDate.getHour() >= ADDITIONAL_VALUE_HOUR) {
				quotationValue += quotationValue * Quotation.ADDITIONAL_VALUE_PRE_8;
			}
			return new Quotation(startDate, endDate, quotationValue);
		} else {
			throw new NoServiceException("Los Domingos no hay servicio!");
		}
	}

}