package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{

}