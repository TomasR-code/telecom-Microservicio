package com.telecom.telecom.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.telecom.telecom.model.Partido;
import com.telecom.telecom.model.Provincia;
import org.springframework.stereotype.Repository;

@Repository
public class PartidoPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Partido getPartidoByNameAndIdProvincia(Provincia provincia, String partido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Partido> criteriaQuery = criteriaBuilder.createQuery(Partido.class);
        Root<Partido> root = criteriaQuery.from(Partido.class);
        Predicate obtenerPartido = criteriaBuilder.like(root.get("nombrePartido"), partido + "%");
        Predicate obtenerProvincia = criteriaBuilder.equal(root.get("provincia"), provincia);
        Predicate obtenerCombinacion = criteriaBuilder.and(obtenerProvincia, obtenerPartido);
        criteriaQuery.where(obtenerCombinacion);
        TypedQuery<Partido> resultado = entityManager.createQuery(criteriaQuery);
        try {
            return resultado.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}