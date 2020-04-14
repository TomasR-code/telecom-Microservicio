package com.telecom.telecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.telecom.telecom.model.Pais;
import com.telecom.telecom.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	PaisRepository paisRepository;
		
	public Optional<Pais> buscarPais(Long pa) {
		Optional<Pais> pais = paisRepository.findById(pa);
		return pais;
	}

	public void guardarPais(Pais pais) {
		paisRepository.save(pais);
	}
}
