package com.example.demo.golovin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ThereIsNoSuchException extends RuntimeException{
    public ThereIsNoSuchException() {
    }
}
