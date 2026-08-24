package com.satolepsystems.task_tracker.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dados de resposta do usuário.")
public record UsuarioResponseDTO(

        @Schema(description = "Identificador único do usuário", example = "1")
        Long id,

        @Schema(description = "Nome do usuário", example = "Fernando Cruz")
        String nome,

        @Schema(description = "E-mail do usuário", example = "fernando@exemplo.com")
        String email,

        @Schema(description = "Data e hora de criação do cadastro", example = "2026-08-23T19:30:00")
        LocalDateTime dataCriacao

) {
}
