package com.squad.dao.impl;

import com.squad.dao.AddressDAO;
import com.squad.model.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Address address) {
        entityManager.persist(address);
    }
}
