package com.satolepsystems.task_tracker.controller;

import com.satolepsystems.task_tracker.dto.tarefa.TarefaRequestDTO;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaResponseDTO;
import com.satolepsystems.task_tracker.service.TarefaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody @Valid TarefaRequestDTO dto) {
        TarefaResponseDTO tarefaCriada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @GetMapping("usuario/{usuarioId}")
    public ResponseEntity<List<TarefaResponseDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listaPorUsuario(usuarioId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TarefaResponseDTO> alterarStatusConclusao(@PathVariable Long id) {
        return ResponseEntity.ok(service.alternarStatusConclusao(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
