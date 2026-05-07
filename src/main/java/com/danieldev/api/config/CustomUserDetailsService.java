package com.danieldev.api.config;

import com.danieldev.api.entity.Usuario;
import com.danieldev.api.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));
        return new User(usuario.getEmail(), usuario.getSenha(), Collections.emptyList());
    }
}