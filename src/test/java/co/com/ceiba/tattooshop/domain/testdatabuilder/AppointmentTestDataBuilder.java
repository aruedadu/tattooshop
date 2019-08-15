package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.model.Artist;

public class AppointmentTestDataBuilder {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Artist tattooArtist;

	public AppointmentTestDataBuilder withStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	public AppointmentTestDataBuilder withEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
		return this;
	}

	public AppointmentTestDataBuilder withTattooArtist(Artist tattooArtist) {
		this.tattooArtist = tattooArtist;
		return this;
	}
	
	public Appointment build() {
		return new Appointment(this.startDate, this.endDate, this.tattooArtist);
	}

}
