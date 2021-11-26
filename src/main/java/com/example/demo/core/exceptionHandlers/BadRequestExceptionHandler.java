package com.example.demo.core.exceptionHandlers;

import com.example.demo.core.exceptions.BadRequestException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BadRequestExceptionHandler {
  

    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> handleConflict(BadRequestException ex, WebRequest request) {

        return ResponseEntity.status(ex.getCode()).body(ex.getExceptions());
    }
}
