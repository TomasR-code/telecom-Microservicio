package com.telecom.telecom.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.service.BarrioService;

@RestController
public class Controller {

	@Autowired
	BarrioService barService;
	
	@GetMapping("/buscarBarrio/{id}")
	public Optional<Barrio> buscarBarrio(@PathVariable Long id) {
		Optional<Barrio> barrioBuscado = barService.buscarBarrio(id);
		if (barrioBuscado != null) {
			System.out.println("barrio, HttpStatus.OK");
		} else {
			System.out.println("No se encontro, HttpStatus.BAD_REQUEST");
		}
		return barrioBuscado;
	}

	@PutMapping("/ActualizarBarrio")
	public ResponseEntity<?> actualizarBarrio(@RequestBody Barrio ba) {
		Optional<Barrio> barrio = buscarBarrio(ba.getId());
		if (barrio != null) {
			Barrio barrioGuardado = barrio.get();
			barrioGuardado.setNombre("Villa Urquiza");
			barrioGuardado = barService.guardarBarrio(barrioGuardado);
			return new ResponseEntity<>(barrio, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se pudo guardar", HttpStatus.BAD_REQUEST);
		}
	}

}
