package co.com.ceiba.tattooshop.domain.model;

public class Artist {

	private long id;

	private String artistIdNumber;

	private String artistFullName;

	public Artist() {
		super();
	}

	public Artist(long id, String artistIdNumber, String artistFullName) {
		super();
		this.id = id;
		this.artistIdNumber = artistIdNumber;
		this.artistFullName = artistFullName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
