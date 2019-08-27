package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.tattooshop.domain.model.Quotation;

public class QuotationTestDataBuilder {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private long totalQuotationValue;
	private int duracion;

	public QuotationTestDataBuilder withStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	public QuotationTestDataBuilder withEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
		return this;
	}

	public QuotationTestDataBuilder whitTotalQuotationValue(long totalQuotationValue) {
		this.totalQuotationValue = totalQuotationValue;
		return this;
	}

	public QuotationTestDataBuilder withDuration(int duracion) {
		this.duracion = duracion;
		return this;
	}

	public Quotation build() {
		return new Quotation(this.startDate, this.endDate, this.totalQuotationValue, this.duracion);
	}

}
