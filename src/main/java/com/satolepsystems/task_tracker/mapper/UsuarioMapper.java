package com.satolepsystems.task_tracker.mapper;

import com.satolepsystems.task_tracker.domain.Usuario;
import com.satolepsystems.task_tracker.domain.enums.UserRole;
import com.satolepsystems.task_tracker.dto.auth.RegisterDTO;
import com.satolepsystems.task_tracker.dto.usuario.UsuarioRequestDTO;
import com.satolepsystems.task_tracker.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .build();
    }

    public Usuario toEntity(RegisterDTO dto, String encryptedPassword) {

        UserRole userRole = dto.role() != null ? dto.role() : UserRole.USER;

        return Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(encryptedPassword)
                .role(userRole)
                .build();

    }

    public UsuarioResponseDTO toDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataCriacao()
        );
    }

}
