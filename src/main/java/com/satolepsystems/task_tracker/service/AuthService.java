package com.satolepsystems.task_tracker.service;

import com.satolepsystems.task_tracker.domain.Usuario;
import com.satolepsystems.task_tracker.dto.auth.AuthenticationDTO;
import com.satolepsystems.task_tracker.dto.auth.LoginResponseDTO;
import com.satolepsystems.task_tracker.dto.auth.RegisterDTO;
import com.satolepsystems.task_tracker.infrastructure.exceptions.BusinessException;
import com.satolepsystems.task_tracker.infrastructure.security.TokenService;
import com.satolepsystems.task_tracker.mapper.UsuarioMapper;
import com.satolepsystems.task_tracker.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    public LoginResponseDTO login(AuthenticationDTO dto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return new LoginResponseDTO(token);

    }

    @Transactional
    public void register(RegisterDTO dto) {

        if (this.usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
        }

        String encryptedPassword = passwordEncoder.encode(dto.senha());

        Usuario novoUsuario = usuarioMapper.toEntity(dto, encryptedPassword);

        this.usuarioRepository.save(novoUsuario);

    }

}
