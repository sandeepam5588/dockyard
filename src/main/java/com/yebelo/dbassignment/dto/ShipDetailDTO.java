package com.yebelo.dbassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipDetailDTO {
    private int id;
    private String name;
    private double length;
    private double width;
    private double height;
    private String entryPoint;
    private String exitPoint;
    private String status;
}
