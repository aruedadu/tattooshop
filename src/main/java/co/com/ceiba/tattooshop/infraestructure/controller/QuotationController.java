package co.com.ceiba.tattooshop.infraestructure.controller;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.tattooshop.domain.model.Quotation;
import co.com.ceiba.tattooshop.domain.service.QuotationService;

@RestController
@RequestMapping(value = "/tattooshop/cotizacion", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuotationController {

	@Autowired
	QuotationService servicio;

	@RequestMapping(value="/generar", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Quotation consultarCotizacion(@RequestParam(value = "fechaInicial") Date fechaInicial,
			@RequestParam(value = "duracion") int duracion) {

		return servicio.getQuotation(fechaInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
				duracion);

	}

}
