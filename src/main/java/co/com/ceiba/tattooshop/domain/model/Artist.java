package co.com.ceiba.tattooshop.domain.model;

public class Artist {

	private String artistIdNumber;

	private String artistFullName;

	public Artist() {
		super();
	}

	public Artist(String artistIdNumber, String artistFullName) {
		super();
		this.artistIdNumber = artistIdNumber;
		this.artistFullName = artistFullName;
	}

	public String getArtistIdNumber() {
		return artistIdNumber;
	}

	public void setArtistIdNumber(String artistIdNumber) {
		this.artistIdNumber = artistIdNumber;
	}

	public String getArtistFullName() {
		return artistFullName;
	}

	public void setArtistFullName(String artistFullName) {
		this.artistFullName = artistFullName;
	}

}
