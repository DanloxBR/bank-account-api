package com.danieldev.api.service;

import com.danieldev.api.config.JwtService;
import com.danieldev.api.dto.request.LoginRequestDTO;
import com.danieldev.api.dto.response.TokenResponseDTO;
import com.danieldev.api.entity.Usuario;
import com.danieldev.api.repository.UsuarioRepository;
import com.danieldev.api.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public TokenResponseDTO login(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new BadCredentialsException("Email ou senha inválidos"));
        boolean senhaValida = passwordEncoder.matches(dto.getSenha(), usuario.getSenha());
        if (!senhaValida) {
            throw new BadCredentialsException("Email ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuario.getEmail());
        return new TokenResponseDTO(token);
    }
}