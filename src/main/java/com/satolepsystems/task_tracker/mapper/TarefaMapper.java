package com.satolepsystems.task_tracker.mapper;

import com.satolepsystems.task_tracker.domain.Tarefa;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaRequestDTO;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public Tarefa toEntity(TarefaRequestDTO dto) {
        return Tarefa.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .concluida(false)
                .build();
    }

    public TarefaResponseDTO toDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getConselho(),
                tarefa.getConcluida(),
                tarefa.getDataCriacao(),
                tarefa.getUsuario() != null ? tarefa.getUsuario().getId() : null
        );
    }

}
