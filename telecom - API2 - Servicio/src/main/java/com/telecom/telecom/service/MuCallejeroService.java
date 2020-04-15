package com.telecom.telecom.service;

import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.model.Provincia;
import com.telecom.telecom.persistencia.ProvinciaPersistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuCallejeroService {

    @Autowired
	ProvinciaPersistencia ProvinciaPersistencia;

    public boolean verificarEnMuCallejero() {
        int numero;
        boolean bool = true;
        numero = (int) (Math.random() * 10) + 1;
        if (numero > 5) {
            bool = true;
        }
        return bool;
    }

	public Provincia buscarProvincia(Long pa) {
		Provincia pronvicia = ProvinciaPersistencia.getPaisById(pa);
		return pronvicia;
	}

	public boolean buscarEnMuCallejero(long pais, Long provincia, long partido, long localidad, long barrio, Domicilio domicilio) {
		return true;
	}

}