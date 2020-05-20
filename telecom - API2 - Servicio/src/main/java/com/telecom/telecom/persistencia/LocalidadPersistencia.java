package com.telecom.telecom.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.telecom.telecom.model.Localidad;
import com.telecom.telecom.model.Partido;
import org.springframework.stereotype.Repository;

@Repository
public class LocalidadPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Localidad getlocalidadByNameAndPartido(Partido partido, String localidad) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Localidad> criteriaQuery = criteriaBuilder.createQuery(Localidad.class);
        Root<Localidad> root = criteriaQuery.from(Localidad.class);
        Predicate obtenerLocalidad = criteriaBuilder.like(root.get("nombreLocalidad"), localidad + "%");
        Predicate obtenerPartido = criteriaBuilder.equal(root.get("partido"), partido);
        Predicate obtenerCombinacion = criteriaBuilder.and(obtenerPartido, obtenerLocalidad);
        criteriaQuery.where(obtenerCombinacion);
        TypedQuery<Localidad> resultado = entityManager.createQuery(criteriaQuery);
        try {
            return resultado.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}