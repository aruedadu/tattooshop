package co.com.ceiba.tattooshop.domain.model;

import java.time.LocalDateTime;

public class Appointment {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Artist tattooArtist;
	private String thirdIdNumber;

	public Appointment(LocalDateTime startDate, LocalDateTime endDate, Artist tattooArtist, String thirdIdNumber) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.tattooArtist = tattooArtist;
		this.thirdIdNumber = thirdIdNumber;
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

	public Artist getTattooArtist() {
		return tattooArtist;
	}

	public void setTattooArtist(Artist tattooArtist) {
		this.tattooArtist = tattooArtist;
	}

	public String getThirdIdNumber() {
		return thirdIdNumber;
	}

	public void setThirdIdNumber(String thirdIdNumber) {
		this.thirdIdNumber = thirdIdNumber;
	}

}
