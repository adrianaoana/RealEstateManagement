package com.squad.dao.impl;

import com.squad.dao.OfferDAO;
import com.squad.model.Offer;
import com.squad.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Offer offer) {
        entityManager.persist(offer);
    }

    @Override
    public void update(Offer offer) {
        entityManager.merge(offer);
    }

    @Override
    public void delete(Offer offer) {
        entityManager.remove(offer);
    }

    @Override
    public List<Offer> getAll() {
        return entityManager.createQuery("SELECT o FROM Offer o", Offer.class).getResultList();
    }

    @Override
    public Offer getOfferById(int idOffer) {
        return entityManager.find(Offer.class, idOffer);
    }
}
