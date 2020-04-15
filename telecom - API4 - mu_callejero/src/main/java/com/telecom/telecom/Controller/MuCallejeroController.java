package com.telecom.telecom.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.service.DomicilioService;
import com.telecom.telecom.service.MuCallejeroService;
import com.telecom.telecom.service.PaisService;

@RestController
public class MuCallejeroController {

	@Autowired
	PaisService paisService;

	@Autowired
	MuCallejeroService muCallejeroService;

	@Autowired
	DomicilioService domicilioService;

	/*
	 * @GetMapping("/domicilio/{id}") public ResponseEntity<?>
	 * getDomicilio(@PathVariable long id) { Optional domicilio =
	 * domicilioService.buscarDomicilio(id); if (domicilio.isPresent()) { return new
	 * ResponseEntity<>(domicilio, HttpStatus.OK);
	 * 
	 * } else { return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
	 * } }
	 */

	/*
	 * @GetMapping("/provincia/{id}") public ResponseEntity<?>
	 * getDomicilio(@PathVariable long id) { Optional domicilio =
	 * provinciaService.buscarProvincia(id); if (domicilio.isPresent()) { return new
	 * ResponseEntity<>(domicilio, HttpStatus.OK);
	 * 
	 * } else { return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
	 * } }
	 */

	@GetMapping("/pais/{id}")
	public ResponseEntity<?> getPis(@PathVariable long id) {
		Optional pais = paisService.buscarPais(id);
		if (pais.isPresent()) {
			return new ResponseEntity<>(pais, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/domicilio/{domicilio}")
	public ResponseEntity<?> pais(@PathVariable long domicilio) {
		Optional dom = domicilioService.buscarDomicilio(domicilio);
		return dom != null ? new ResponseEntity<>(dom, HttpStatus.OK)
				: new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/buscarMuCallejero/{idPais}/{idProvincia}/{idPartido}/{idLocalidad}/{idBarrio}")
	public ResponseEntity<?> pais(@PathVariable long idPais, @PathVariable long idProvincia, @PathVariable long idPartido,
			@PathVariable long idLocalidad, @PathVariable long idBarrio, @RequestBody Domicilio domicilio) {
		boolean resultadoMuCallejero = false;
		resultadoMuCallejero = muCallejeroService.buscarEnMuCallejero(idPais, idProvincia, idPartido, idLocalidad, idBarrio, domicilio);
		return resultadoMuCallejero != false ? new ResponseEntity<>("ok", HttpStatus.OK)
				: new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
	}

}