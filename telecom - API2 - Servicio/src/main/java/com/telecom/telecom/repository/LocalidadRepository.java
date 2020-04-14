package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

}