package com.satolepsystems.task_tracker.infrastructure.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
