// 代码生成时间: 2025-09-24 18:03:08
package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ErrorHandlingComponent {

    // Define a simple GET endpoint to demonstrate error handling
    @GetMapping("/error")
    public ResponseEntity<String> triggerError() {
        throw new CustomException("An error occurred");
    }

    // Exception handler for CustomException
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Define a custom exception class
    public static class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }
}
