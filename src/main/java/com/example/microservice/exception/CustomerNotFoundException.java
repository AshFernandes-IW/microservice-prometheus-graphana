package com.example.microservice.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("The customer id '" + id + "' does not exist in our records");
    }
}