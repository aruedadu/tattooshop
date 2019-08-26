package co.com.ceiba.tattooshop.domain.unit;

import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.repository.AppointmentRepository;
import co.com.ceiba.tattooshop.domain.service.AppointmentService;
import co.com.ceiba.tattooshop.domain.testdatabuilder.AppointmentTestDataBuilder;
import co.com.ceiba.tattooshop.domain.testdatabuilder.ArtistTestDataBuilder;

public class AppointmentServiceTest {
	
	@Mock
	AppointmentRepository repoAppointment;
	
	@Mock
	ModelMapper mapper;
	

	@Test
	public void createAppointmentTest() {

	}

	public void saveAppointmentTest() {

		// arrange
		LocalDateTime startDate = LocalDateTime.of(2019, Month.AUGUST, 15, 9, 0);
		LocalDateTime endDate = LocalDateTime.of(2019, Month.AUGUST, 15, 12, 0);
		Artist artist = new ArtistTestDataBuilder().withId(1).withArtistIdNumber("1037604310")
				.withArtistFullName("Alejandro Rueda").build();
		Appointment appointment = new AppointmentTestDataBuilder().withStartDate(startDate).withEndDate(endDate)
				.withTattooArtist(artist).build();
		
		AppointmentService service = new AppointmentService();
		AppointmentRepository repo = mock(AppointmentRepository.class);
		
		//act
		service.crearCita(appointment);
		
		//assert
		
		

	}

}
