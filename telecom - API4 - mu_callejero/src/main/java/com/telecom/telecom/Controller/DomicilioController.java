package com.telecom.telecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.service.BasePropiaService;
import com.telecom.telecom.service.MuCallejeroService;

@RestController
public class DomicilioController {

	@Autowired
	MuCallejeroService muCallejeroService;

	@Autowired
	BasePropiaService BasePropiaService;

	@PostMapping("/buscarBasePropia/{idProvincia}/{partido}/{localidad}/{barrio}/{domicilio}/{numeroDomicilio}")
	public ResponseEntity<?> BuscarMuCallejero(@PathVariable long idProvincia,
			@PathVariable String partido, @PathVariable String localidad, @PathVariable String barrio,
			@PathVariable String domicilio, @PathVariable Integer numeroDomicilio) {
		boolean resultadoBusquedaEnNuestraBase = false;
		resultadoBusquedaEnNuestraBase = BasePropiaService.buscarEnNuestraBase(idProvincia, partido, localidad,
				barrio, domicilio,numeroDomicilio);

		return resultadoBusquedaEnNuestraBase != false ? new ResponseEntity<>("ok", HttpStatus.OK)
				: new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
	}

/* 	@GetMapping("/domicilio/{id}")
	public ResponseEntity<?> getDomicilio(@PathVariable long id) {
		Optional domicilio = domicilioService.buscarDomicilio(id);
		if (domicilio.isPresent()) {
			return new ResponseEntity<>(domicilio, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
		}
	} */

	/*
	 * @GetMapping("/provincia/{id}") public ResponseEntity<?>
	 * getDomicilio(@PathVariable long id) { Optional domicilio =
	 * provinciaService.buscarProvincia(id); if (domicilio.isPresent()) { return new
	 * ResponseEntity<>(domicilio, HttpStatus.OK);
	 * 
	 * } else { return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
	 * } }
	 */

//	@GetMapping("/pais/{id}")
//	public ResponseEntity<?> getPis(@PathVariable long id) {
//		Optional pais = paisService.buscarPais(id);
//		if (pais.isPresent()) {
//			return new ResponseEntity<>(pais, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
//		}
//	}

//	@GetMapping("/domicilio/{domicilio}")
//	public ResponseEntity<?> pais(@PathVariable long domicilio) {
//		Optional dom = domicilioService.buscarDomicilio(domicilio);
//		return dom != null ? new ResponseEntity<>(dom, HttpStatus.OK)
//				: new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
//	}

/* 	@GetMapping("/domicilioBody")
	public ResponseEntity<?> domiiclioBody(@RequestBody Domicilio domicilio) {
		Optional dom = domicilioService.buscarDomicilio(domicilio.getId());
		return dom != null ? new ResponseEntity<>(dom, HttpStatus.OK)
				: new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
	} */
}