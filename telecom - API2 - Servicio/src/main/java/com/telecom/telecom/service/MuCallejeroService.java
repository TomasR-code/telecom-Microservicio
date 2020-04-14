package com.telecom.telecom.service;

import java.util.List;
import java.util.Optional;
import com.telecom.telecom.model.Pais;
import com.telecom.telecom.persistencia.PaisPersistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuCallejeroService {

    @Autowired
	PaisPersistencia paisPersistencia;

    public boolean verificarEnMuCallejero(Optional<Pais> pais) {
        int numero;
        boolean bool = true;
        numero = (int) (Math.random() * 10) + 1;
        if (numero > 5) {
            bool = true;
        }
        return bool;
    }

	public Pais buscarPais(Long pa) {
        Pais pais = paisPersistencia.getPaisById(pa);
		return pais;
	}

}