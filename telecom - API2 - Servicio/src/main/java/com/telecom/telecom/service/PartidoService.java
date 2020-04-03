package com.telecom.telecom.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.telecom.model.Partido;
import com.telecom.telecom.repository.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	PartidoRepository partidoRepository;
	
	public Optional<Partido> buscarPartido(Long pa) {
		Optional<Partido> partido = partidoRepository.findById(pa);
		return partido;
	}

	public void guardarPartido(Partido par) {
		partidoRepository.save(par);
	}
}
