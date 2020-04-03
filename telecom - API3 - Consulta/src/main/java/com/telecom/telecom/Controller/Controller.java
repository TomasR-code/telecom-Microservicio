package com.telecom.telecom.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.service.DomicilioService;

@RestController
public class Controller {

	@Autowired
	DomicilioService domService;
	
	@GetMapping("/domicilio/{id}")
	public ResponseEntity<?> getDomicilio(@PathVariable long id) {
		Optional domicilio = domService.buscarDomicilio(id);
		if (domicilio.isPresent()) {
			return new ResponseEntity<>(domicilio, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>("no encotrada", HttpStatus.NO_CONTENT);
		}
	}
	
	
}
