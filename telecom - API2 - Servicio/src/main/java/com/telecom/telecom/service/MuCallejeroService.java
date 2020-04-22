package com.telecom.telecom.service;

import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.persistencia.DomicilioPersistencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuCallejeroService {

    @Autowired
	DomicilioPersistencia domicilioPersistencia;
    
    @Autowired
    BarrioService barrioService;

    public boolean verificarEnMuCallejero() {
        int numero;
        boolean bool = true;
        numero = (int) (Math.random() * 10) + 1;
        if (numero > 5) {
            bool = true;
        }
        return bool;
    }


	public boolean buscarEnMuCallejero(long provincia, String partido, String localidad, String barrio, String domicilio) {
		List<Domicilio> domicilios = domicilioPersistencia.getDomicilioByName(domicilio);
		if(domicilio.isEmpty()) {
			barrioService.buscarBarrioPorNombre(domicilios, barrio);
			return true;
		}
		return false;
	}

}