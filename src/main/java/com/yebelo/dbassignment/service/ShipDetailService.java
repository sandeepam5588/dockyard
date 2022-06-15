package com.yebelo.dbassignment.service;

import com.yebelo.dbassignment.entity.ShipDetail;
import com.yebelo.dbassignment.exceptions.ShipDetailsNotFoundException;

import java.util.List;

public interface ShipDetailService {

    ShipDetail findShip(int id) throws ShipDetailsNotFoundException;

    ShipDetail addShipDetails(ShipDetail shipDetail);

    List<ShipDetail> findAllShipDetails();

    void deleteShipDetail(int id);

    ShipDetail updateShipDetail(ShipDetail shipDetail, int id) throws ShipDetailsNotFoundException;
}
