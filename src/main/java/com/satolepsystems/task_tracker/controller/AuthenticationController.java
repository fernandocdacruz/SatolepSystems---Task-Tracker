package com.satolepsystems.task_tracker.controller;

import com.satolepsystems.task_tracker.dto.auth.AuthenticationDTO;
import com.satolepsystems.task_tracker.dto.auth.LoginResponseDTO;
import com.satolepsystems.task_tracker.dto.auth.RegisterDTO;
import com.satolepsystems.task_tracker.infrastructure.exceptions.ProblemDetailDTO;
import com.satolepsystems.task_tracker.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "x")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints para login e registro de usuários")
public class AuthenticationController {

    private final AuthService authService;

    @Operation(summary = "Realizar Login", description = "Autentica o usuário e retorna o token JWT.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autenticado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Credenciais inválidas ou requisição incorreta",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dto) {

        LoginResponseDTO response = authService.login(dto);

        return ResponseEntity.ok(response);

    }

    @Operation(summary = "Registrar novo usuário", description = "Cadastra um novo usuário no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou e-mail já existente",
                    content = @Content(schema = @Schema(implementation = ProblemDetailDTO.class)))
    })
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO dto) {

        authService.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
