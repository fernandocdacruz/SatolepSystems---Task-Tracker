package com.satolepsystems.task_tracker.dto.auth;

import com.satolepsystems.task_tracker.domain.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(

        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100)
        String nome,

        @NotBlank(message =  "O e-mail é obrigatório.")
        @Email
        @Size(max = 100)
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 6)
        String senha,

        UserRole role

) {
}
