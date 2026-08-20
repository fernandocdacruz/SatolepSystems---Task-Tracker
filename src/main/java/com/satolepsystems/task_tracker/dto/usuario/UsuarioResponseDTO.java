package com.satolepsystems.task_tracker.dto.usuario;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        LocalDateTime dataCriacao

) {
}
