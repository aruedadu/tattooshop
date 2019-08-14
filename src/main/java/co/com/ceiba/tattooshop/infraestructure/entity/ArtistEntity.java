package co.com.ceiba.tattooshop.infraestructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTIST")
public class ArtistEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ARTIST_ID_NUMBER", nullable = false)
	private String artistIdNumber;

	@Column(name = "ARTIST_FULL_NAME", nullable = false)
	private String artistFullName;

	public ArtistEntity() {
	}

	public ArtistEntity(long id, String artistIdNumber, String artistFullName) {
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
