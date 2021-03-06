package co.com.ceiba.tattooshop.domain.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.exception.NoServiceException;
import co.com.ceiba.tattooshop.domain.model.Quotation;

@Service
public class QuotationService {

	private static final DayOfWeek NO_SERVICE_DAY = DayOfWeek.SUNDAY;
	private static final int ADDITIONAL_VALUE_HOUR = 20;
	private static final int MIN_SERVICE_HOUR = 10;
	private static final int HORA_MAXIMA_ATENCION = 24;

	public Quotation getQuotation(LocalDateTime startDate, int duration) {
		if (startDate.getDayOfWeek() == NO_SERVICE_DAY) {
			throw new NoServiceException("Los Domingos no hay servicio!");
		}
		if (startDate.getHour() < MIN_SERVICE_HOUR) {
			throw new NoServiceException("El servicio inicia a las 10 am");
		}
		if (duration > (HORA_MAXIMA_ATENCION - startDate.getHour())) {
			throw new NoServiceException("No es posible agendar una cita cuya duracion supere la media noche.");
		}
		LocalDateTime endDate = startDate.plusHours(duration);
		long quotationValue = Quotation.TATTOO_HOUR_VALUE * duration;
		if (startDate.getHour() >= ADDITIONAL_VALUE_HOUR) {
			quotationValue += quotationValue * Quotation.ADDITIONAL_VALUE_POS_8;
		} else if (endDate.getHour() >= ADDITIONAL_VALUE_HOUR) {
			quotationValue += quotationValue * Quotation.ADDITIONAL_VALUE_PRE_8;
		}
		return new Quotation(startDate, endDate, quotationValue);
	}

}