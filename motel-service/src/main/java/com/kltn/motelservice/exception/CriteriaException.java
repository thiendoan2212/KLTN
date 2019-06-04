package com.kltn.motelservice.exception;

public class CriteriaException extends RuntimeException {
    public CriteriaException(String message) {
        super(message);
    }

    public CriteriaException(String message, Throwable cause) {
        super(message, cause);
    }
}
