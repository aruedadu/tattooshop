package co.com.ceiba.tattooshop.domain.testdatabuilder;

import co.com.ceiba.tattooshop.domain.model.Artist;

public class ArtistTestDataBuilder {

	private long id;

	private String artistIdNumber;

	private String artistFullName;

	public ArtistTestDataBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public ArtistTestDataBuilder withArtistIdNumber(String artistIdNumber) {
		this.artistIdNumber = artistIdNumber;
		return this;
	}

	public ArtistTestDataBuilder withArtistFullName(String artistFullName) {
		this.artistFullName = artistFullName;
		return this;
	}

	public Artist build() {
		return new Artist(this.id, this.artistIdNumber, this.artistFullName);
	}

}
