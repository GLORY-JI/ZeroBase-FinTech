package com.zerobase.fintech.exception.handler;

import com.zerobase.fintech.exception.ExistEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExistEmailExceptionHandler {

    @ExceptionHandler(ExistEmailException.class)
    public ResponseEntity<?> Exception(ExistEmailException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
