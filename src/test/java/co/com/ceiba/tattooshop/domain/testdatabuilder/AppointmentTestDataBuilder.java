package co.com.ceiba.tattooshop.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.model.Artist;

public class AppointmentTestDataBuilder {

	private long id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Artist tattooArtist;
	private String thirdIdNumber;

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

	public AppointmentTestDataBuilder withThirdIdNumber(String thirdIdNumber) {
		this.thirdIdNumber = thirdIdNumber;
		return this;
	}

	public AppointmentTestDataBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public Appointment build() {
		return new Appointment(this.startDate, this.endDate, this.tattooArtist, this.thirdIdNumber);
	}
	
	public Appointment buildWithId() {
		return new Appointment(this.id, this.startDate, this.endDate, this.tattooArtist, this.thirdIdNumber);
	}

}
