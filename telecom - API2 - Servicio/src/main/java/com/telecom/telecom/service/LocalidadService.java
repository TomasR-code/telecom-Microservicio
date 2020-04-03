package com.telecom.telecom.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.telecom.model.Localidad;
import com.telecom.telecom.repository.LocalidadRepository;

@Service
public class LocalidadService {

	@Autowired
	LocalidadRepository localidadRepository;
	
	public Optional<Localidad> buscarLocalidad(Long lo) {
		Optional<Localidad> localidad = localidadRepository.findById(lo);
		return localidad;
	}

	public void guardarLocalidad(Localidad lo) {
		localidadRepository.save(lo);
	}
	
}
