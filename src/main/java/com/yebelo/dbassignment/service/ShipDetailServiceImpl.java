package com.yebelo.dbassignment.service;

import com.yebelo.dbassignment.entity.ShipDetail;
import com.yebelo.dbassignment.exceptions.ShipDetailsNotFoundException;
import com.yebelo.dbassignment.repository.ShipDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipDetailServiceImpl implements ShipDetailService{
    @Autowired
    private ShipDetailRepository shipRepo;

    @Override
    public ShipDetail findShip(int id) throws ShipDetailsNotFoundException {
        ShipDetail shipDetail = shipRepo.findById(id).orElseThrow(()-> new ShipDetailsNotFoundException(id));
        shipDetail.setHeight(shipDetail.getHeight()*10);
        shipDetail.setWidth(shipDetail.getWidth()*10);
        shipDetail.setLength(shipDetail.getLength()*10);
        return shipDetail;
    }

    @Override
    public ShipDetail addShipDetails(ShipDetail shipDetail) {
        shipDetail.setHeight(shipDetail.getHeight()/10);
        shipDetail.setWidth(shipDetail.getWidth()/10);
        shipDetail.setLength(shipDetail.getLength()/10);
        return shipRepo.save(shipDetail);
    }

    @Override
    public List<ShipDetail> findAllShipDetails() {
        Pageable sortedByIdDesc = PageRequest.of(0, 10, Sort.by("id").descending());
        return shipRepo.findAll(sortedByIdDesc).stream().collect(Collectors.toList());
    }

    @Override
    public void deleteShipDetail(int id) {
        shipRepo.deleteById(id);
    }

    @Override
    public ShipDetail updateShipDetail(ShipDetail shipDetail, int id) throws ShipDetailsNotFoundException {
        ShipDetail retrievedShipDetail = shipRepo.findById(id).orElseThrow(()-> new ShipDetailsNotFoundException(id));
        retrievedShipDetail.setName(shipDetail.getName());
        retrievedShipDetail.setLength(shipDetail.getLength());
        retrievedShipDetail.setWidth(shipDetail.getWidth());
        retrievedShipDetail.setHeight(shipDetail.getHeight());
        retrievedShipDetail.setEntryPoint(shipDetail.getEntryPoint());
        retrievedShipDetail.setExitPoint(shipDetail.getExitPoint());
        retrievedShipDetail.setStatus(shipDetail.getStatus());
        return addShipDetails(retrievedShipDetail);
    }
}
