package com.yebelo.dbassignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "Journey")
@SecondaryTable(name="Vessel", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class ShipDetail {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", table = "Vessel")
    private String name;

    @Column(name = "length", table = "Vessel")
    private int length;

    @Column(name = "width", table = "Vessel")
    private int width;

    @Column(name = "height", table = "Vessel")
    private int height;

    @Column(name = "Entry_Point")
    private String entryPoint;

    @Column(name = "Exit_point")
    private String exitPoint;

    @Column(name = "Status")
    private String status;
}
