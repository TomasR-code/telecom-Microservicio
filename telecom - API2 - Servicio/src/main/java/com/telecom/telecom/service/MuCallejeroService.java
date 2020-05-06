package com.telecom.telecom.service;

import org.springframework.stereotype.Service;

@Service
public class MuCallejeroService {

    public boolean verificarEnMuCallejero() {
        int numero;
        boolean bool = true;
        numero = (int) (Math.random() * 10) + 1;
        if (numero > 5) {
            bool = true;
        }
        return bool;
    }
}