package com.satolepsystems.task_tracker.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetailDTO> handleResourceNotFound(ResourceNotFoundException exception) {

        ProblemDetailDTO problem = new ProblemDetailDTO(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado.",
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetailDTO> handleBusiness(BusinessException exception) {

        ProblemDetailDTO problem = new ProblemDetailDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Regra de negócio violada.",
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);

    }

    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<ProblemDetailDTO> handTokenGeneration(TokenGenerationException exception) {

        ProblemDetailDTO problem = new ProblemDetailDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno ao gerar o token de acesso.",
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problem);

    }

}
