package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlantGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlantExceptionResponse> handleException(PlantException plantException){
        PlantExceptionResponse response= new PlantExceptionResponse(plantException.getMessage(), plantException.getHttpStatus().value());
        return new ResponseEntity<>(response, plantException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantExceptionResponse> handleException(Exception exception){
        PlantExceptionResponse response= new PlantExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
