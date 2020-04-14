package com.telecom.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Barrio;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Long>{

}
