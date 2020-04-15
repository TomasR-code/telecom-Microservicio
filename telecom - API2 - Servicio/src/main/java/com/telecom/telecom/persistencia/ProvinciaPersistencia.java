package com.telecom.telecom.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.telecom.telecom.model.Provincia;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinciaPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Provincia getPaisById(Long idProvincia) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Provincia> criteriaQuery = criteriaBuilder.createQuery(Provincia.class);
        Root<Provincia> root = criteriaQuery.from(Provincia.class);
        TypedQuery<Provincia> query = entityManager.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), idProvincia)));
        
        return query.getSingleResult();
    }


  


}