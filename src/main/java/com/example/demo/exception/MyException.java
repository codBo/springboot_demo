package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.UNAUTHORIZED)
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
    
}