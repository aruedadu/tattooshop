package co.com.ceiba.tattooshop.domain.model;

public class Artist {

	private long id;
	private String artistFullName;
	private String artistIdNumber;


	public Artist(long id, String artistFullName, String artistIdNumber) {
		super();
		this.id = id;
		this.artistIdNumber = artistIdNumber;
		this.artistFullName = artistFullName;
	}
	
	public Artist() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtistFullName() {
		return artistFullName;
	}

	public void setArtistFullName(String artistFullName) {
		this.artistFullName = artistFullName;
	}

	public String getArtistIdNumber() {
		return artistIdNumber;
	}

	public void setArtistIdNumber(String artistIdNumber) {
		this.artistIdNumber = artistIdNumber;
	}

}
