package com.yebelo.dbassignment.service;

import com.yebelo.dbassignment.entity.ShipDetail;
import com.yebelo.dbassignment.repository.ShipDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipDetailServiceImpl implements ShipDetailService{
    private ShipDetailRepository shipRepo;
    @Override
    public ShipDetail findShip(int id) {
        return shipRepo.findById(id).get();
    }
}