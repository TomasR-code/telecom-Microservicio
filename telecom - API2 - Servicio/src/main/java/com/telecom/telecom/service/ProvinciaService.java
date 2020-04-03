package com.telecom.telecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.telecom.telecom.model.Provincia;
import com.telecom.telecom.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	ProvinciaRepository provinciaRepository;

	public Optional<Provincia> buscarProvincia(Long pro) {
		Optional<Provincia> provincia = provinciaRepository.findById(pro);
		return provincia;
	}

	public void guardarProvincia(Provincia pro) {
		provinciaRepository.save(pro);
	}
}
