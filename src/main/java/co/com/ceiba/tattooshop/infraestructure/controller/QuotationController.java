package co.com.ceiba.tattooshop.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.tattooshop.domain.model.Quotation;
import co.com.ceiba.tattooshop.domain.service.QuotationService;

@RestController
@RequestMapping(value = "/tattooshop/cotizacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuotationController {

	@Autowired
	QuotationService servicio;

	@PostMapping("/generar")
	public @ResponseBody Quotation consultarCotizacion(@RequestBody Quotation payload) {
		
		return servicio.getQuotation(payload.getStartDate(),
				payload.getDuracion());

	}

}