package com.satolepsystems.task_tracker.controller;

import com.satolepsystems.task_tracker.dto.tarefa.TarefaRequestDTO;
import com.satolepsystems.task_tracker.dto.tarefa.TarefaResponseDTO;
import com.satolepsystems.task_tracker.infrastructure.exceptions.ProblemDetailDTO;
import com.satolepsystems.task_tracker.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Tarefas", description = "Endpoints para gerenciamento de tarefas")
public class TarefaController {

    private final TarefaService service;

    @Operation(summary = "Criar tarefa", description = "Cria uma nova tarefa associada a um usuário existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuário informado não existe",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody @Valid TarefaRequestDTO dto) {
        TarefaResponseDTO tarefaCriada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @Operation(summary = "Listar tarefas por usuário", description = "Retorna todas as tarefas pertencentes a um determinado usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário informado não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TarefaResponseDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listaPorUsuario(usuarioId));
    }

    @Operation(summary = "Alternar status de conclusão", description = "Inverte o estado do atributo 'concluida' (true/false) de uma tarefa.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Status alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @PatchMapping("/{id}/status")
    public ResponseEntity<TarefaResponseDTO> alterarStatusConclusao(@PathVariable Long id) {
        return ResponseEntity.ok(service.alternarStatusConclusao(id));
    }

    @Operation(summary = "Deletar tarefa", description = "Remove uma tarefa do sistema pelo seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tarefa removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
