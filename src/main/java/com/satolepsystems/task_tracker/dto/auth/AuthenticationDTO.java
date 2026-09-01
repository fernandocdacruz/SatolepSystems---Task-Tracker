package com.satolepsystems.task_tracker.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        @NotBlank(message = "O e-mail é obrigatório.")
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        String senha

) {

}
