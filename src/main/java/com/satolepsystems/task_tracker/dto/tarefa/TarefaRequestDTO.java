package com.satolepsystems.task_tracker.dto.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TarefaRequestDTO(

        @NotBlank(message = "O título é obrigatório")
        @Size(max = 150, message = "O título deve ter no máximo 150 caracteres.")
        String titulo,

        String descricao,

        @NotNull(message = "O ID do usuário é obrigatório.")
        Long usuarioId

) {
}
