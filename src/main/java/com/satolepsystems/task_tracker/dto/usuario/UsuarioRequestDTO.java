package com.satolepsystems.task_tracker.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Payload para a criação de um novo usuário.")
public record UsuarioRequestDTO(

        @Schema(description = "Nome completo do usuário", example = "Fernando Cruz")
        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,

        @Schema(description = "E-mail de acesso do usuário.", example = "fernando@exemplo.com")
        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "O formato do e-mail é inválido.")
        @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
        String email,

        @Schema(description = "Senha de acesso do usuário", example = "senhaSegura123")
        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
        String senha

) {
}
