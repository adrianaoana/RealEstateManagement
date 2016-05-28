package com.squad.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.squad.dao.ImageDAO;
import com.squad.model.Image;

@Repository
public class ImageDAOImpl implements ImageDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(Image image) {
		entityManager.persist(image);

	}

	@Override
	public void update(Image image) {
		entityManager.merge(image);

	}

	@Override
	public void delete(Image image) {
		entityManager.remove(image);

	}

	@Override
	public List<Image> getAllByOfferId(int offerId) {
		return entityManager.createQuery("SELECT i FROM Image i WHERE i.offer.id= :id", Image.class)
				.setParameter("id", offerId).getResultList();
	}

}
