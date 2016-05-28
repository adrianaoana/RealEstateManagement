package com.squad.dao.impl;

import com.squad.dao.OfferDAO;
import com.squad.model.Offer;

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

	@Override
	public Long getByPageFilterSize(String type, String propertyType, String beginPrice, String limitPrice) {
		if (type != null && !type.isEmpty()) {
			if (propertyType != null && !propertyType.isEmpty()) {
				// nothing is null
				return entityManager
						.createQuery("SELECT COUNT(1) AS NR"
								+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type and o.feature.propertyType= :propertyType "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice", Long.class)
						.setParameter("type", type).setParameter("propertyType", propertyType)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.getSingleResult();

			} else { // property type is null
				return entityManager
						.createQuery("SELECT COUNT(1) AS NR FROM Offer o WHERE o.dateDeleted is null and o.type= :type "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice", Long.class)
						.setParameter("type", type).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).getSingleResult();
			}
		} else {
			// type is null
			if (propertyType != null && !propertyType.isEmpty()) {
				return entityManager
						.createQuery("SELECT COUNT(1) AS NR"
								+ " FROM Offer o WHERE o.dateDeleted is null and o.feature.propertyType= :propertyType "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice", Long.class)
						.setParameter("propertyType", propertyType).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).getSingleResult();

			} else {
				return entityManager
						.createQuery("SELECT COUNT(1) AS NR FROM Offer o WHERE o.dateDeleted is null "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice", Long.class)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.getSingleResult();
			}
		}

	}

	@Override
	public Long getByPageFilterBySearchSize(String type, String propertyType, String beginPrice, String limitPrice,
			String search) {
		if (type != null && !type.isEmpty()) {
			if (propertyType != null && !propertyType.isEmpty()) {
				// nothing is null
				return entityManager
						.createQuery(
								"SELECT COUNT(1) AS NR"
										+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type and o.feature.propertyType= :propertyType "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
										+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
										+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)",
								Long.class)
						.setParameter("type", type).setParameter("propertyType", propertyType)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setParameter("search", "%" + search + "%").getSingleResult();

			} else { // property type is null
				return entityManager
						.createQuery(
								"SELECT COUNT(1) AS NR" + " FROM Offer o WHERE o.dateDeleted is null and o.type= :type "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
										+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
										+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)",
								Long.class)
						.setParameter("type", type).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setParameter("search", "%" + search + "%")
						.getSingleResult();
			}
		} else {
			// type is null
			if (propertyType != null && !propertyType.isEmpty()) {
				return entityManager
						.createQuery(
								"SELECT COUNT(1) AS NR"
										+ " FROM Offer o WHERE o.dateDeleted is null and o.feature.propertyType= :propertyType "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
										+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
										+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)",
								Long.class)
						.setParameter("propertyType", propertyType).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setParameter("search", "%" + search + "%")
						.getSingleResult();

			} else {
				return entityManager
						.createQuery(
								"SELECT COUNT(1) AS NR FROM Offer o WHERE o.dateDeleted is null "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
										+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
										+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)",
								Long.class)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setParameter("search", "%" + search + "%").getSingleResult();
			}
		}
	}

	@Override
	public List<Offer> getByPageFilterOrder(String type, String propertyType, String beginPrice, String limitPrice,
			String order, Integer offset, Integer recordsPerPage) {
		if (type != null && !type.isEmpty()) {
			if (propertyType != null && !propertyType.isEmpty()) {
				// nothing is null
				return entityManager
						.createQuery(
								"SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
										+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type and o.feature.propertyType= :propertyType "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice" + " order by " + order,
								Offer.class)
						.setParameter("type", type).setParameter("propertyType", propertyType)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setFirstResult(offset).setMaxResults(recordsPerPage).getResultList();
			} else { // property type is null
				return entityManager
						.createQuery(
								"SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
										+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice" + " order by " + order,
								Offer.class)
						.setParameter("type", type).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setFirstResult(offset).setMaxResults(recordsPerPage)
						.getResultList();
			}
		} else {
			// type is null
			if (propertyType != null && !propertyType.isEmpty()) {
				return entityManager
						.createQuery(
								"SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
										+ " FROM Offer o WHERE o.dateDeleted is null and o.feature.propertyType= :propertyType "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice" + " order by " + order,
								Offer.class)
						.setParameter("propertyType", propertyType).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setFirstResult(offset).setMaxResults(recordsPerPage)
						.getResultList();
			} else {
				return entityManager
						.createQuery(
								"SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
										+ " FROM Offer o WHERE o.dateDeleted is null "
										+ " and o.price>= :beginPrice and o.price<= :limitPrice" + " order by " + order,
								Offer.class)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setFirstResult(offset).setMaxResults(recordsPerPage).getResultList();
			}
		}
	}

	@Override
	public List<Offer> getByPageFilterOrderSearch(String type, String propertyType, String beginPrice,
			String limitPrice, String search, String order, Integer offset, Integer recordsPerPage) {
		if (type != null && !type.isEmpty()) {
			if (propertyType != null && !propertyType.isEmpty()) {
				// nothing is null
				return entityManager
						.createQuery("SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
								+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type and o.feature.propertyType= :propertyType "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
								+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
								+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)" + " order by "
								+ order, Offer.class)
						.setParameter("type", type).setParameter("propertyType", propertyType)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setParameter("search", "%" + search + "%").setFirstResult(offset).setMaxResults(recordsPerPage)
						.getResultList();
			} else { // property type is null
				return entityManager
						.createQuery("SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
								+ " FROM Offer o WHERE o.dateDeleted is null and o.type= :type "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
								+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
								+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)" + " order by "
								+ order, Offer.class)
						.setParameter("type", type).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setParameter("search", "%" + search + "%")
						.setFirstResult(offset).setMaxResults(recordsPerPage).getResultList();
			}
		} else {
			// type is null
			if (propertyType != null && !propertyType.isEmpty()) {
				return entityManager
						.createQuery("SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
								+ " FROM Offer o WHERE o.dateDeleted is null and o.feature.propertyType= :propertyType "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
								+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
								+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)" + " order by "
								+ order, Offer.class)
						.setParameter("propertyType", propertyType).setParameter("beginPrice", beginPrice)
						.setParameter("limitPrice", limitPrice).setParameter("search", "%" + search + "%")
						.setFirstResult(offset).setMaxResults(recordsPerPage).getResultList();
			} else {
				return entityManager
						.createQuery("SELECT new Offer( o.type, o.price, o.emailUser, o.dateAdded, o.feature, o.address, o.id)"
								+ " FROM Offer o WHERE o.dateDeleted is null "
								+ " and o.price>= :beginPrice and o.price<= :limitPrice AND (o.type LIKE :search OR o.feature.propertyType LIKE :search "
								+ " OR o.feature.comfort LIKE :search OR o.feature.division LIKE :search OR o.price LIKE :search "
								+ " OR o.address.street LIKE :search OR o.address.city LIKE :search)" + " order by "
								+ order, Offer.class)
						.setParameter("beginPrice", beginPrice).setParameter("limitPrice", limitPrice)
						.setParameter("search", "%" + search + "%").setFirstResult(offset).setMaxResults(recordsPerPage)
						.getResultList();
			}
		}
	}
}
