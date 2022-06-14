package com.yebelo.dbassignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShipDetail {
    @Id
    private int id;
    private String name;
    private int length;
    private int width;
    private int height;
    private String entryPoint;
    private String exitPoint;
    private String status;
}
