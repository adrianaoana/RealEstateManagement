package com.squad.dao;

import com.squad.model.Offer;

import java.util.List;

public interface OfferDAO {
    public void add(Offer offer);

    public void update(Offer offer);

    public void delete(Offer offer);

    public List<Offer> getAll();

    public Offer getOfferById(int idOffer);

	public Long getByPageFilterSize(String type, String propertyType, String beginPrice, String limitPrice);

	public Long getByPageFilterBySearchSize(String type, String propertyType, String beginPrice, String limitPrice,
			String search);

	public List<Offer> getByPageFilterOrder(String type, String propertyType, String beginPrice, String limitPrice,
			String order, Integer offset, Integer recordsPerPage);

	public List<Offer> getByPageFilterOrderSearch(String type, String propertyType, String beginPrice,
			String limitPrice, String search, String order, Integer offset, Integer recordsPerPage);

}
