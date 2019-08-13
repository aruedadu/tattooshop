package co.com.ceiba.tattooshop.domain.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Quotation;

@Service
public class QuotationService {

	public static final DayOfWeek NO_SERVICE_DAY = DayOfWeek.SUNDAY;

	public Quotation getQuotation(LocalDateTime startDate, int duration) {
		LocalDateTime endDate = startDate.plusHours(duration);
		return new Quotation();
	}

}