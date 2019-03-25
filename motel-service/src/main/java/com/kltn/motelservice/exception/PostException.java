package com.kltn.motelservice.exception;

public class PostException extends RuntimeException {
    public PostException(String message) {
        super(message);
    }

    public PostException(String message, Throwable cause) {
        super(message, cause);
    }
}
