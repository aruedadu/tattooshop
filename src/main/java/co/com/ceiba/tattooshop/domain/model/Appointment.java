package co.com.ceiba.tattooshop.domain.model;

import java.time.LocalDateTime;

public class Appointment {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Artist tattooArtist;

	public Appointment() {//TODO: QUITAR CONSTRUCTOR VACIO.
		super();
	}

	public Appointment(LocalDateTime startDate, LocalDateTime endDate, Artist tattooArtist) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.tattooArtist = tattooArtist;
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

}
