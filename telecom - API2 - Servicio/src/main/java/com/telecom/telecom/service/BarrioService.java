package com.telecom.telecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.repository.BarrioRepository;

@Service
public class BarrioService {

	@Autowired
	private BarrioRepository barrioRepository;

	public Barrio guardarBarrio(Barrio barrio) {
		Barrio barrioGuardado = barrioRepository.save(barrio);
		return barrioGuardado;	
	}

	public Optional<Barrio> buscarBarrio(Long ba) {
		Optional<Barrio> barrio = barrioRepository.findById(ba);
		return barrio;
	}

}