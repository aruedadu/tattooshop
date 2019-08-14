package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.tattooshop.domain.model.Quotation;

public class QuotationTestDataBuilder {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private long totalQuotationValue;

	public QuotationTestDataBuilder(LocalDateTime startDate, LocalDateTime endDate, long totalQuotationValue) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalQuotationValue = totalQuotationValue;
	}

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
	
	public Quotation build() {
		return new Quotation(this.startDate, this.endDate, this.totalQuotationValue);
	}

}
