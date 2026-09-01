package com.satolepsystems.task_tracker.service;

import com.satolepsystems.task_tracker.domain.Usuario;
import com.satolepsystems.task_tracker.domain.enums.UserRole;
import com.satolepsystems.task_tracker.dto.usuario.UsuarioRequestDTO;
import com.satolepsystems.task_tracker.dto.usuario.UsuarioResponseDTO;
import com.satolepsystems.task_tracker.infrastructure.exceptions.BusinessException;
import com.satolepsystems.task_tracker.infrastructure.exceptions.ResourceNotFoundException;
import com.satolepsystems.task_tracker.mapper.UsuarioMapper;
import com.satolepsystems.task_tracker.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();

    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        return mapper.toDTO(usuario);

    }

    @Transactional
    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
        }

        repository.deleteById(id);

    }

}
