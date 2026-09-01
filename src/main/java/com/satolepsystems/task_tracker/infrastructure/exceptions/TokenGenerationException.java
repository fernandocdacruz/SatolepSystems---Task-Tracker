package com.satolepsystems.task_tracker.infrastructure.exceptions;

public class TokenGenerationException extends RuntimeException {
    public TokenGenerationException(String message) {
        super(message);
    }
}
