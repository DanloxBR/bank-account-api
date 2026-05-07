package com.danieldev.api.controller;

import com.danieldev.api.dto.request.LoginRequestDTO;
import com.danieldev.api.dto.response.TokenResponseDTO;
import com.danieldev.api.service.AuthService;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        TokenResponseDTO response = authService.login(dto);
        return ResponseEntity.ok(response);
    }
}
