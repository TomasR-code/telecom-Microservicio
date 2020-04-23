package com.telecom.telecom.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.repository.DomicilioRepository;

@Service
public class DomicilioService {

	@Autowired
	DomicilioRepository domRepository;

	public Optional<Domicilio> buscarDomicilio(long dom) {
		Optional<Domicilio> domicilio;
		domicilio = domRepository.findById(dom);
		return domicilio;
	}

	public Domicilio guardarDomicilio(Domicilio domicilio) {
		Domicilio domicilioGuardado = domRepository.save(domicilio);
		System.out.println(domicilio);
		return domicilioGuardado;
	}

}