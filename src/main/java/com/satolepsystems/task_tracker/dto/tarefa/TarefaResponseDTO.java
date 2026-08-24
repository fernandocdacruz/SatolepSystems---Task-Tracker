package com.satolepsystems.task_tracker.dto.tarefa;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record TarefaResponseDTO(

        @Schema(description = "Identificador único da tarefa.", example = "10")
        Long id,

        @Schema(description = "Título da tarefa.", example = "Configurar Swagger na API")
        String titulo,

        @Schema(description = "Descrição detalhada da tarefa.", example = "Mapear endpoints com anotações do OpenAPI")
        String descricao,

        @Schema(description = "Indica se a tarefa está concluída.", example = "false")
        Boolean concluida,

        @Schema(description = "Data e hora de criação da tarefa.", example = "2026-08-23T20:00:00")
        LocalDateTime dataCriacao,

        @Schema(description = "ID do usuário associado.", example = "1")
        Long usuarioId

) {
}
