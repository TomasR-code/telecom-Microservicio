package com.telecom.telecom.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.model.Localidad;
import org.springframework.stereotype.Repository;

@Repository
public class BarrioPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Barrio getBarrioByNameAndLocalidad(Localidad localidad, String barrio) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Barrio> criteriaQuery = criteriaBuilder.createQuery(Barrio.class);
        Root<Barrio> root = criteriaQuery.from(Barrio.class);
        Predicate obtenerBarrio = criteriaBuilder.like(root.get("nombre"), barrio + "%");
        Predicate obtenerLocalidad = criteriaBuilder.equal(root.get("localidad"), localidad);
        Predicate obtenerCombinacion = criteriaBuilder.and(obtenerLocalidad, obtenerBarrio);
        criteriaQuery.where(obtenerCombinacion);
        TypedQuery<Barrio> resultado = entityManager.createQuery(criteriaQuery);
        try {
            return resultado.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}