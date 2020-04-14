package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{

}