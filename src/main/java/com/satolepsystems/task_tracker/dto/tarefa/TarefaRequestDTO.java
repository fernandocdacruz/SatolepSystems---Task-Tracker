package com.satolepsystems.task_tracker.dto.tarefa;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TarefaRequestDTO(

        @Schema(description = "Título da tarefa", example = "Configurar Swagger na API")
        @NotBlank(message = "O título é obrigatório")
        @Size(max = 150, message = "O título deve ter no máximo 150 caracteres.")
        String titulo,

        @Schema(description = "Descrição detalhada da tarefa", example = "Mapear endpoints com anotações do OpenAPI")
        String descricao,

        @Schema(description = "ID do usuário associado à tarefa", example = "1")
        @NotNull(message = "O ID do usuário é obrigatório.")
        Long usuarioId

) {
}
