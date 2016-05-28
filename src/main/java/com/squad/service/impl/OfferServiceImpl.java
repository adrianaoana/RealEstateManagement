package com.squad.service.impl;

import com.squad.dao.ImageDAO;
import com.squad.dao.OfferDAO;
import com.squad.model.Offer;
import com.squad.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferDAO offerDAO;
	
	@Autowired
	private ImageDAO imageDAO;

	@Override
	@Transactional
	public void add(Offer offer) {
		offerDAO.add(offer);
	}

	@Override
	@Transactional
	public void update(Offer offer) {
		offerDAO.update(offer);
	}

	@Override
	@Transactional
	public void delete(Offer offer) {
		offerDAO.delete(offer);
	}

	@Override
	@Transactional
	public List<Offer> getAll() {
		return offerDAO.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Offer getOfferById(int idOffer) {
		return offerDAO.getOfferById(idOffer);
	}

	@Override
	@Transactional(readOnly = true)
	public Long getByPageFilterBySearchSize(String type, String propertyType, String beginPrice, String limitPrice,
			String search) {
		if (beginPrice == null || beginPrice.isEmpty()) {
			beginPrice = "0";
		}
		if (limitPrice == null || limitPrice.isEmpty()) {
			limitPrice = "9999999";
		}
		if (search == null || search.isEmpty()) {
			return offerDAO.getByPageFilterSize(type, propertyType, beginPrice, limitPrice);
		} else {
			return offerDAO.getByPageFilterBySearchSize(type, propertyType, beginPrice, limitPrice, search);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object getByPageFilterBySearch(String type, String propertyType, String beginPrice, String limitPrice,
			String search, String order, Integer offset, Integer recordsPerPage) {
		if (order == null || order.isEmpty() || order.contentEquals("0")) {
			order = "o.dateAdded desc, o.id desc";
		} else if (order.contentEquals("1")) {
			order = "o.dateAdded, o.id";
		} else if (order.contentEquals("2")) {
			order = "o.price, o.id";
		} else {
			order = "o.price desc, o.id";
		}
		if (beginPrice == null || beginPrice.isEmpty()) {
			beginPrice = "0";
		}
		if (limitPrice == null || limitPrice.isEmpty()) {
			limitPrice = "9999999";
		}
		List<Offer> offers;
		if (search == null || search.isEmpty()) {
			offers = offerDAO.getByPageFilterOrder(type, propertyType, beginPrice, limitPrice, order, offset,
					recordsPerPage);
		} else {
			offers = offerDAO.getByPageFilterOrderSearch(type, propertyType, beginPrice, limitPrice, search, order,
					offset, recordsPerPage);
		}
		for (Offer offer : offers) {
			offer.setImages(imageDAO.getAllByOfferId(offer.getId()));
		}
		return offers;
	}
}
