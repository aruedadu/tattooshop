package co.com.ceiba.tattooshop.domain.model;

import java.util.Date;

public class Appointment {

	private Date startDate;
	private Date endDate;
	private Artist tattooArtist;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Artist getTattooArtist() {
		return tattooArtist;
	}

	public void setTattooArtist(Artist tattooArtist) {
		this.tattooArtist = tattooArtist;
	}

}
