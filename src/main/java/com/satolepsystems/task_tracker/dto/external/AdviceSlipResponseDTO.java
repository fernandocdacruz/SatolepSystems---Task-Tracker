package com.satolepsystems.task_tracker.dto.external;

public record AdviceSlipResponseDTO(Slip slip) {

    public record Slip(Long id, String advice) {}

}
