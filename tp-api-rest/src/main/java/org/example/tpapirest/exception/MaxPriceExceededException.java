package org.example.tpapirest.exception;

public class MaxPriceExceededException extends RuntimeException {
    public MaxPriceExceededException(String message) {
        super(message);
    }
}
