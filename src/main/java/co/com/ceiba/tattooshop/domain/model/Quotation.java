package co.com.ceiba.tattooshop.domain.model;

import java.time.LocalDateTime;

public class Quotation {

	public static final long TATTOO_HOUR_VALUE = 150000;
	public static final double ADDITIONAL_VALUE_POS_8 = 0.1;
	public static final double ADDITIONAL_VALUE_PRE_8 = 0.05;

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private long totalQuotationValue;

	public Quotation() {
		super();
	}

	public Quotation(LocalDateTime startDate, LocalDateTime endDate, long totalQuotationValue) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalQuotationValue = totalQuotationValue;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public long getTotalQuotationValue() {
		return totalQuotationValue;
	}

	public void setTotalQuotationValue(long totalQuotationValue) {
		this.totalQuotationValue = totalQuotationValue;
	}

}
