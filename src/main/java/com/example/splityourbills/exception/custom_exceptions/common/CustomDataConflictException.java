package com.example.splityourbills.exception.custom_exceptions.common;

public class CustomDataConflictException extends RuntimeException {
    public CustomDataConflictException() {
        super();
    }

    public CustomDataConflictException(String message) {
        super(message);
    }
}
