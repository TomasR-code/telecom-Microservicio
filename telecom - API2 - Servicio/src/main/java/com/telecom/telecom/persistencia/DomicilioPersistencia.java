package com.telecom.telecom.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Domicilio;

@Repository
public class DomicilioPersistencia {
	
    @PersistenceContext
    private EntityManager entityManager;

    public List<Domicilio> getDomicilioByName(String domicilio) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Domicilio> criteriaQuery = criteriaBuilder.createQuery(Domicilio.class);
        Root<Domicilio> root = criteriaQuery.from(Domicilio.class);
        TypedQuery<Domicilio> query = entityManager.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("calle"), domicilio)));
        
        return query.getResultList();
    }

}
