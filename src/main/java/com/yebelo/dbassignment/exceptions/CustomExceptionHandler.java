package com.yebelo.dbassignment.exceptions;

import com.yebelo.dbassignment.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ShipDetailsNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleShipDetailsNotFoundException(ShipDetailsNotFoundException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "please provide the valid id"
        );
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

}
