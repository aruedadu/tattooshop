package co.com.ceiba.tattooshop.infraestructure.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.tattooshop.domain.model.Appointment;
import co.com.ceiba.tattooshop.domain.model.Artist;
import co.com.ceiba.tattooshop.domain.service.AppointmentService;
import co.com.ceiba.tattooshop.infraestructure.controller.peticiones.CrearCitaRequest;
import co.com.ceiba.tattooshop.infraestructure.controller.utlidades.UtilitariosFecha;

@CrossOrigin
@RestController
@RequestMapping(value = "/tattooshop/appointment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {

	@Autowired
	AppointmentService servicio;

	@PostMapping(value = "/crear-cita")
	public void crearCita(@RequestBody CrearCitaRequest cita) {
		LocalDateTime fechaInicioCita = UtilitariosFecha.utilConvertToLocal(cita.getFechaInicio());
		Artist artista = new Artist();
		artista.setId(Long.parseLong(cita.getArtistaId()));
		Appointment appointment = new Appointment(fechaInicioCita, fechaInicioCita.plusHours(cita.getDuracion()),
				artista, cita.getTerceroNumeroId());
		servicio.crearCita(appointment);
	}

	@PostMapping(value = "/cancelar-cita")
	public void cancelarCita(@RequestBody Appointment appointment) {
		servicio.cancelarCita(appointment);
	}

	@PostMapping(value = "/consultar-cita")
	public @ResponseBody Appointment consultarCita(@RequestParam(value = "fechaCita") String cedulaTercero,
			@RequestParam(value = "fechaCita") LocalDateTime fechaCita) {
		return servicio.consultarCita(cedulaTercero, fechaCita);
	}

	@PostMapping(value = "/consultar-todas-citas")
	public @ResponseBody List<LocalDateTime> consultarTodasLasCitas(
			@RequestParam(value = "fechaCita") String cedulaTercero) {
		return servicio.consultarTodasLasCitas(cedulaTercero);
	}

}
