package com.squad.service.impl;

import com.squad.dao.FeatureDAO;
import com.squad.model.Feature;
import com.squad.model.Image;
import com.squad.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureDAO featureDAO;

    @Override
    @Transactional
    public void add(Feature feature) {
        featureDAO.add(feature);
    }

}
