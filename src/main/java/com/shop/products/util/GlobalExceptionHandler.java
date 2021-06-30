package com.shop.products.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleValidationException(HttpServletRequest req, Exception e) {
        if (e instanceof ValidationException) {
            return ResponseEntity.badRequest().body("Bad Request: " + e.getMessage());
        }
        return ResponseEntity.badRequest().body("Error while processing the request.");
    }
}
