package com.squad.service;

import com.squad.model.Offer;

import java.util.List;

public interface OfferService {

	public void add(Offer offer);

	public void update(Offer offer);

	public void delete(Offer offer);

	public List<Offer> getAll();

	public Offer getOfferById(int idOffer);

	public Long getByPageFilterBySearchSize(String type, String propertyType, String search);

	public Object getByPageFilterBySearch(String type, String propertyType, String search, String order, int i,
			Integer recordsPerPage);

}
