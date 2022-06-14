package com.yebelo.dbassignment.controller;

import com.yebelo.dbassignment.dto.ShipDetailDTO;
import com.yebelo.dbassignment.entity.ShipDetail;
import com.yebelo.dbassignment.service.ShipDetailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipDetailController {
    @Autowired
    private ShipDetailServiceImpl shipDetailService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<ShipDetailDTO> getShipDetail(@PathVariable(name = "id") int id){
        ShipDetail shipDetail = shipDetailService.findShip(id);
        if(shipDetail != null){
            ShipDetailDTO shipDTO = modelMapper.map(shipDetail, ShipDetailDTO.class);
            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
