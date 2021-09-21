package com.example.demo.golovin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    public ResponseEntity<ApiError> handlerException(){
        return new ResponseEntity<>(new ApiError("There is no such"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistsException.class)
    public ResponseEntity<ApiError> handlerExceptionNoEntityByID(){
        return new ResponseEntity<>(new ApiError("There is no such by id"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShorNameException.class)
    public ResponseEntity<ApiError> handlerShortName(){
        return new ResponseEntity<>(new ApiError("There is short name"), HttpStatus.NOT_FOUND);
    }
}
