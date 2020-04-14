package com.telecom.telecom.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.telecom.telecom.model.Pais;
import org.springframework.stereotype.Repository;

@Repository
public class PaisPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Pais getPaisById(Long idpais) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Pais> criteriaQuery = criteriaBuilder.createQuery(Pais.class);
        Root<Pais> root = criteriaQuery.from(Pais.class);
        TypedQuery<Pais> query = entityManager.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), idpais)));
        
        return query.getSingleResult();
    }


  


}