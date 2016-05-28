package com.squad.service.impl;

import com.squad.dao.OfferDAO;
import com.squad.model.Offer;
import com.squad.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OfferServiceImpl implements OfferService{
    @Autowired
    private OfferDAO offerDAO;

    @Override
    @Transactional
    public void add(Offer offer) {
         offerDAO.add(offer);
    }

    @Override
    public void update(Offer offer) {
        offerDAO.update(offer);
    }

    @Override
    public void delete(Offer offer) {
        offerDAO.delete(offer);
    }

    @Override
    public List<Offer> getAll() {
        return offerDAO.getAll();
    }

    @Override
    public Offer getOfferById(int idOffer) {
        return offerDAO.getOfferById(idOffer);
    }
}
