package co.com.ceiba.tattooshop.domain.model;

public class Quotation {

	private static final double TATTOO_HOUR_VALUE = 150000;
	private static final double ADITIONAL_VALUE_POS_8 = 0.1;
	private static final double ADITIONAL_VALUE_PRE_8 = 0.05;

	private double totalQuotationValue;

	public Quotation() {
		super();
	}

	public Quotation(double totalQuotationValue) {
		super();
		this.totalQuotationValue = totalQuotationValue;
	}

	public double getTotalQuotationValue() {
		return totalQuotationValue;
	}

	public void setTotalQuotationValue(double totalQuotationValue) {
		this.totalQuotationValue = totalQuotationValue;
	}

//	public Quotation getQuotation(Date startHour, Date endHour) {		
//		int diff = (int) ((endHour.getTime() - startHour.getTime()) / 1000);
//		int hours = (diff / 3600);
//		diff = diff - (hours * 3600);
//		double basePrice = diff * TATTOO_HOUR_VALUE;
//		
//		
//		
//		Quotation quotation = new Quotation(hours);
//		return quotation;
//	}

}
