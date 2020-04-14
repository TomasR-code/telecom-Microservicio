package com.telecom.telecom.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.model.Pais;
import com.telecom.telecom.service.MuCallejeroService;
import com.telecom.telecom.service.PaisService;

@RestController
public class Controller {

	@Autowired
	PaisService paisService;

	@Autowired
	MuCallejeroService muCallejeroService;

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

	/*
	 * @GetMapping("/pais/{id}") public ResponseEntity<?> getPis(@PathVariable long
	 * id) { Optional pais = paisService.buscarPais(id); if (pais.isPresent()) {
	 * return new ResponseEntity<>(pais, HttpStatus.OK); } else { return new
	 * ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT); } }
	 */

	@GetMapping("/buscarMuCallejero")
	public ResponseEntity<?> actualizarDomicilio(@RequestBody Pais pa) {
		Optional<Pais> pais;
		boolean muCallejeroEncontrado;
		// criteria
		pais = paisService.buscarPais(pa.getId());

		if (pais.isPresent()) {
			return new ResponseEntity<>("Encontrado", HttpStatus.OK);
		} else {
			muCallejeroEncontrado = muCallejeroService.verificarEnMuCallejero(pais);
			if (muCallejeroEncontrado) {
				paisService.guardarPais(pa);
				return new ResponseEntity<>("Encontrado en muCallejero y agregado a la base local", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
			}
		}
	}

	@GetMapping("/pais/{pa}")
	public ResponseEntity<?> pais(@PathVariable Long pa) {
		Pais pais;
		// criteria
		pais = muCallejeroService.buscarPais(pa);

		return pais != null ? new ResponseEntity<>(pais, HttpStatus.OK) : new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);		
	}

}