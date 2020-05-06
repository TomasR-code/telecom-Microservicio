package com.telecom.telecom.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.model.Domicilio;

@Repository
public class DomicilioPersistencia {

    @PersistenceContext
    private EntityManager entityManager;

    public Domicilio getDomicilioByBarrio(Barrio barrio, String calle, Long numeroDomicilio) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Domicilio> criteriaQuery = criteriaBuilder.createQuery(Domicilio.class);
        Root<Domicilio> root = criteriaQuery.from(Domicilio.class);
        Predicate obtenerDomicilio = criteriaBuilder.like(root.get("calle"), calle +"%");
        Predicate obtenerBarrio = criteriaBuilder.equal(root.get("barrio"), barrio);
        Predicate obtenerCombinacion = criteriaBuilder.and(obtenerBarrio, obtenerDomicilio);
        criteriaQuery.where(obtenerCombinacion);
        TypedQuery<Domicilio> resultado = entityManager.createQuery(criteriaQuery);
        try {
            return resultado.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }   

	public Object getDomicilio(long idProvincia, String partido, String localidad, String barrio, String calle,
			Long numeroDomicilio) {
		return null;
    }
    
    /*     public List<Domicilio> getDomicilioByName(String calle) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Domicilio> criteriaQuery = criteriaBuilder.createQuery(Domicilio.class);
        Root<Domicilio> root = criteriaQuery.from(Domicilio.class);
        TypedQuery<Domicilio> query = entityManager
                .createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("calle"), calle)));

        return query.getResultList();
    } */
}
