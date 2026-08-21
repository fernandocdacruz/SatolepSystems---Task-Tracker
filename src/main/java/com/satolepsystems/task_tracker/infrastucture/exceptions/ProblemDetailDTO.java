package com.satolepsystems.task_tracker.infrastucture.exceptions;

import java.time.LocalDateTime;

public record ProblemDetailDTO(
        int status,
        String title,
        String detail,
        LocalDateTime timestamp
) {

    public ProblemDetailDTO(int status, String title, String detail) {
        this(status, title, detail, LocalDateTime.now());
    }

}
