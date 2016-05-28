package com.squad.dao;

import com.squad.model.Offer;

import java.util.List;

public interface OfferDAO {
    public void add(Offer offer);

    public void update(Offer offer);

    public void delete(Offer offer);

    public List<Offer> getAll();

    public Offer getOfferById(int idOffer);
}
