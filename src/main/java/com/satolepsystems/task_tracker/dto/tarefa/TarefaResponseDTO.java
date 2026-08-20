package com.satolepsystems.task_tracker.dto.tarefa;

import java.time.LocalDateTime;

public record TarefaResponseDTO(

        Long id,
        String titulo,
        String descricao,
        Boolean concluida,
        LocalDateTime dataCriacao,
        Long usuarioId

) {
}
