package com.example.splityourbills.exception.custom_exceptions.common;

public class InternalServerException extends RuntimeException {
    public InternalServerException() {
        super();
    }

    public InternalServerException(String message) {
        super(message);
    }
}
