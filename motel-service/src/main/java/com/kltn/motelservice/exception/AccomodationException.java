package com.kltn.motelservice.exception;

public class AccomodationException extends RuntimeException {
    public AccomodationException(String message) {
        super(message);
    }

    public AccomodationException(String message, Throwable cause) {
        super(message, cause);
    }
}
