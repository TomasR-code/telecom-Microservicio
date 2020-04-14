package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}