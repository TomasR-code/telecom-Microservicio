package com.telecom.telecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.service.DomicilioService;

@RestController
public class Controller {

	@Autowired
	DomicilioService domService;

    @PutMapping("/ActualizarCalle")
    public Domicilio updateCalle(@RequestBody Domicilio body) {
      return domService.guardarDomicilio(body);
    }
	
	
}
