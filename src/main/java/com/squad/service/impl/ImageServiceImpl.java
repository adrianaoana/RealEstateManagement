package com.squad.service.impl;

import com.squad.dao.ImageDAO;
import com.squad.model.Image;
import com.squad.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDAO imageDAO;

    @Override
    @Transactional
    public void add(Image image) {
        imageDAO.add(image);
    }
}
