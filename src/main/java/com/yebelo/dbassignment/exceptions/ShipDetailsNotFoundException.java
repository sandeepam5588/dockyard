package com.yebelo.dbassignment.exceptions;

public class ShipDetailsNotFoundException extends Exception{
    public ShipDetailsNotFoundException(int id){
        super("id "+id+" not found");
    }
}
