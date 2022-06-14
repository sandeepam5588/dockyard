package com.yebelo.dbassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipDetailDTO {
    private int id;
    private String name;
    private int length;
    private int width;
    private int height;
    private String entryPoint;
    private String exitPoint;
    private String status;
}
