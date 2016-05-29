package com.squad.service.impl;

import com.squad.dao.AddressDAO;
import com.squad.model.Address;
import com.squad.model.Image;
import com.squad.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Override
    @Transactional
    public void add(Address address) {
        addressDAO.add(address);
    }

}
