package co.com.ceiba.tattooshop.infraestructure.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "TOTAL_VALUE", nullable = false)
	private double totalValue;

	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
	private ArtistEntity artist;

	@Column(name = "THIRD_ID_NUMBER", nullable = false)
	private String thirdIdNumber;

	public AppointmentEntity() {
	}

	public AppointmentEntity(long id, LocalDateTime startDate, LocalDateTime endDate, double totalValue,
			ArtistEntity artist, String thirdIdNumber) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalValue = totalValue;
		this.artist = artist;
		this.thirdIdNumber = thirdIdNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public ArtistEntity getArtist() {
		return artist;
	}

	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}

	public String getThirdIdNumber() {
		return thirdIdNumber;
	}

	public void setThirdIdNumber(String thirdIdNumber) {
		this.thirdIdNumber = thirdIdNumber;
	}

}
