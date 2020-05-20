package com.telecom.telecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.service.DomicilioService;

@RestController
public class Controller {

    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/crearDomicilio")
    public ResponseEntity<?> crearDomicilio(@RequestBody Domicilio dom) {
        if (dom != null) {
            dom = domicilioService.guardarDomicilio(dom);
            return new ResponseEntity<>(dom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo guardar", HttpStatus.BAD_REQUEST);
        }
    }
	
}