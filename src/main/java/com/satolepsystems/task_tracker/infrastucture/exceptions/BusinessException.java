package com.satolepsystems.task_tracker.infrastucture.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
