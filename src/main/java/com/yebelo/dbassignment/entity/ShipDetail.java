package com.yebelo.dbassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Journey")
@SecondaryTable(name="Vessel", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class ShipDetail {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Entry_Point")
    private String entryPoint;

    @Column(name = "Exit_point")
    private String exitPoint;

    @Column(name = "Status")
    private String status;

    @Column(name = "name", table = "Vessel")
    private String name;

    @Column(name = "length", table = "Vessel")
    private double length;

    @Column(name = "width", table = "Vessel")
    private double width;

    @Column(name = "height", table = "Vessel")
    private double height;
}
