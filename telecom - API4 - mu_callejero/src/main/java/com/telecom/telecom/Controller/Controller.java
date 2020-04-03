package com.telecom.telecom.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.model.Localidad;
import com.telecom.telecom.model.Pais;
import com.telecom.telecom.model.Partido;
import com.telecom.telecom.model.Provincia;
import com.telecom.telecom.service.BarrioService;
import com.telecom.telecom.service.DomicilioService;
import com.telecom.telecom.service.LocalidadService;
import com.telecom.telecom.service.MuCallejeroService;
import com.telecom.telecom.service.PaisService;
import com.telecom.telecom.service.PartidoService;
import com.telecom.telecom.service.ProvinciaService;

@RestController
public class Controller {

	@Autowired
	DomicilioService domicilioService;

	@Autowired
	BarrioService barrioService;

	@Autowired
	LocalidadService localidadService;

	@Autowired
	PartidoService partidoService;

	@Autowired
	ProvinciaService provinciaService;

	@Autowired
	PaisService paisService;

	@Autowired
	MuCallejeroService muCallejeroService;
	
	@GetMapping("/domicilio/{id}")
	public ResponseEntity<?> getDomicilio(@PathVariable long id) {
		Optional domicilio = domicilioService.buscarDomicilio(id);
		if (domicilio.isPresent()) {
			return new ResponseEntity<>(domicilio, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/buscarMuCallejero")
	public ResponseEntity<?> actualizarBarrio(@RequestBody Domicilio dom, @RequestBody Barrio ba,
			@RequestBody Localidad lo, @RequestBody Partido par, @RequestBody Provincia pro, @RequestBody Pais pa) {
		Optional<Domicilio> domicilio;
		Optional<Barrio> barrio;
		Optional<Localidad> localidad;
		Optional<Partido> partido;
		Optional<Provincia> provincia;
		Optional<Pais> pais;
		boolean muCallejeroEncontrado;

		domicilio = domicilioService.buscarDomicilio(dom.getId());
		barrio = barrioService.buscarBarrio(ba.getId());
		localidad = localidadService.buscarLocalidad(lo.getId());
		partido = partidoService.buscarPartido(par.getId());
		provincia = provinciaService.buscarProvincia(pro.getId());
		pais = paisService.buscarPais(pa.getId());

		if (domicilio.isPresent() && barrio.isPresent() && localidad.isPresent() && partido.isPresent()
				&& provincia.isPresent() && pais.isPresent()) {
					return new ResponseEntity<>("Encontrado", HttpStatus.OK);
		}
		else{
			muCallejeroEncontrado = muCallejeroService.verificarEnMuCallejero(domicilio, barrio, localidad, partido, provincia, pais);
			if(muCallejeroEncontrado){
				domicilioService.guardarDomicilio(dom);
				barrioService.guardarBarrio(ba);
				localidadService.guardarLocalidad(lo);
				partidoService.guardarPartido(par);
				provinciaService.guardarProvincia(pro);
				paisService.guardarPais(pa);
				return new ResponseEntity<>("Encontrado en muCallejero y agregado a la base local", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("No encontrado", HttpStatus.BAD_REQUEST);
			}
		}
	} 

	@GetMapping("/pais/{id}")
	public ResponseEntity<?> getPis(@PathVariable long id) {
		Optional pais = paisService.buscarPais(id);
		if (pais.isPresent()) {
			return new ResponseEntity<>(pais, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
		}
	}
}