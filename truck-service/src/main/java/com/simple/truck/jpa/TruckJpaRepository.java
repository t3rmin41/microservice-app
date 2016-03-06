package com.simple.truck.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class TruckJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public List<TruckJpa> getAllTrucksJpa() {
        TypedQuery<TruckJpa> typedQuery = entityManager.createQuery("SELECT t FROM " + TruckJpa.class.getName() + " t", TruckJpa.class);
        return typedQuery.getResultList();
    }

    @Transactional
    public Long addTruck(TruckJpa jpa) {
        return entityManager.merge(jpa).getId();
    }
    
    @Transactional
    public TruckJpa getTruckById(Long truckId) {
        TypedQuery<TruckJpa> typedQuery = entityManager.createQuery("SELECT t FROM " + TruckJpa.class.getName() + " t " +
                                                                    "WHERE t.id = :truck_id", TruckJpa.class);
        typedQuery.setParameter("truck_id", truckId);
        return typedQuery.getSingleResult();
    }

}
