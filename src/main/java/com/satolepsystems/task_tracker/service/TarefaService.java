package com.satolepsystems.task_tracker.service;

import com.satolepsystems.task_tracker.domain.Tarefa;
import com.satolepsystems.task_tracker.domain.Usuario;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaRequestDTO;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaResponseDTO;
import com.satolepsystems.task_tracker.infrastucture.exceptions.ResourceNotFoundException;
import com.satolepsystems.task_tracker.mapper.TarefaMapper;
import com.satolepsystems.task_tracker.repository.TarefaRepository;
import com.satolepsystems.task_tracker.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TarefaMapper mapper;

    @Transactional
    public TarefaResponseDTO criar(TarefaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + dto.usuarioId()));

        Tarefa tarefa = mapper.toEntity(dto);
        tarefa.setUsuario(usuario);

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return mapper.toDTO(tarefaSalva);

    }

    @Transactional(readOnly = true)
    public List<TarefaResponseDTO> listaPorUsuario(Long usuarioId) {

        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + usuarioId);
        }

        return tarefaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(mapper::toDTO)
                .toList();

    }

    @Transactional
    public TarefaResponseDTO alternarStatusConclusao(Long id) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o ID: " + id));

        tarefa.setConcluida(!tarefa.getConcluida());

        return mapper.toDTO(tarefaRepository.save(tarefa));

    }

    @Transactional
    public void deletar(Long id) {

        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarefa não encontrada com o ID: " + id);
        }

        tarefaRepository.deleteById(id);

    }



}
