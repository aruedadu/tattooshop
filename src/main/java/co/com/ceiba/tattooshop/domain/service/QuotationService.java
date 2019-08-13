package co.com.ceiba.tattooshop.domain.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import co.com.ceiba.tattooshop.domain.model.Quotation;

@Service
public class QuotationService {

	public static final int NO_SERVICE_DAY = 7;

	public Quotation getQuotation(LocalDate startDate, int duration) {
		return new Quotation();
	}

}