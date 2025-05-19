package com.catskhi.school.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("message", "The item was not found, try again.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
