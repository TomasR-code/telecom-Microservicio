package com.telecom.telecom.service;

import java.util.Optional;
import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.model.Localidad;
import com.telecom.telecom.model.Pais;
import com.telecom.telecom.model.Partido;
import com.telecom.telecom.model.Provincia;
import org.springframework.stereotype.Service;

@Service
public class MuCallejeroService {

    public boolean verificarEnMuCallejero(Optional<Domicilio> domicilio, Optional<Barrio> barrio,
            Optional<Localidad> localidad, Optional<Partido> partido, Optional<Provincia> provincia,
            Optional<Pais> pais) {
        int numero;
        boolean bool = false;
        numero = (int) (Math.random() * 10) + 1;
        if (numero > 5){
            bool = true;
        }
            return bool;
    }

}