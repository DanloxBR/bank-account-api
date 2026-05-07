package com.danieldev.api.controller;

import com.danieldev.api.entity.Usuario;
import com.danieldev.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(
                usuarioRepository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
}
