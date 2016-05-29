package com.squad.dao.impl;


import com.squad.dao.FeatureDAO;
import com.squad.model.Feature;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FeatureDAOImpl implements FeatureDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Feature feature) {
        entityManager.persist(feature);
    }
}
