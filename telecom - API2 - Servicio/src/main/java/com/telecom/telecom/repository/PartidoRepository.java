package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{

}