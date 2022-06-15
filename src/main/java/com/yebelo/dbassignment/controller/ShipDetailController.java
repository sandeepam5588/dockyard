package com.yebelo.dbassignment.controller;

import com.yebelo.dbassignment.dto.ShipDetailDTO;
import com.yebelo.dbassignment.dto.ShipDetailsListDTO;
import com.yebelo.dbassignment.entity.ShipDetail;
import com.yebelo.dbassignment.exceptions.ShipDetailsNotFoundException;
import com.yebelo.dbassignment.service.ShipDetailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShipDetailController {
    @Autowired
    private ShipDetailServiceImpl shipDetailService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/ship-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDetailDTO> getShipDetail(@PathVariable(name = "id") int id) throws ShipDetailsNotFoundException {
        ShipDetail shipDetail = shipDetailService.findShip(id);
        ShipDetailDTO shipDetailDTO = modelMapper.map(shipDetail, ShipDetailDTO.class);
        return new ResponseEntity<>(shipDetailDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/ship-details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDetailsListDTO> getAllShipDetaisl(){
        List<ShipDetailDTO> shipDetailDTOS = new ArrayList<>();
        for(ShipDetail s : shipDetailService.findAllShipDetails()){
            shipDetailDTOS.add(modelMapper.map(s, ShipDetailDTO.class));
        }
        ShipDetailsListDTO shipDetailsListDTO = new ShipDetailsListDTO(shipDetailDTOS);
        return new ResponseEntity(shipDetailsListDTO, HttpStatus.OK);
    }


    @PostMapping(value = "/ship-details", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDetailDTO> addShipDetail(@RequestBody ShipDetailDTO shipDetailDTO) throws ShipDetailsNotFoundException {
        ShipDetail shipDetail = modelMapper.map(shipDetailDTO, ShipDetail.class);
        shipDetailService.addShipDetails(shipDetail);

        ShipDetail savedShipDetail = shipDetailService.findShip(shipDetailDTO.getId());
        ShipDetailDTO savedShipDTO = modelMapper.map(savedShipDetail, ShipDetailDTO.class);
        return new ResponseEntity<>(savedShipDTO, HttpStatus.CREATED);
    }


    @PutMapping(value = "/ship-details/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDetailDTO> updateShipDetail(@RequestBody ShipDetailDTO shipDetailDTO, @PathVariable(name = "id") int id) throws ShipDetailsNotFoundException {
        ShipDetail shipDetail = modelMapper.map(shipDetailDTO, ShipDetail.class);
        shipDetailService.updateShipDetail(shipDetail, id);

        ShipDetail updatedShipDetail = shipDetailService.findShip(shipDetail.getId());
        ShipDetailDTO updatedShipDetailDTO = modelMapper.map(updatedShipDetail, ShipDetailDTO.class);
        return new ResponseEntity<>(updatedShipDetailDTO, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(value = "/ship-details/{id}")
    public ResponseEntity deleteShipDetail(@PathVariable(name = "id") int id) {
        shipDetailService.deleteShipDetail(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
