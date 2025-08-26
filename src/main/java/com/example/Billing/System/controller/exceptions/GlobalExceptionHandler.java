package com.example.Billing.System.controller.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class )
    public ResponseEntity<?> handleEntityNotFound(Exception e){
        System.out.println("Entering the controller advice");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"+ e.getMessage());
    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity<?> handleMethodArgumentNotValidException(Exception e){
        System.out.println("Entering the controller advice");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request"+ e.getMessage());
    }

}
