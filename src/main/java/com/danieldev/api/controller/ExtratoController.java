package com.danieldev.api.controller;

import com.danieldev.api.dto.response.ExtratoResponseDTO;
import com.danieldev.api.service.ExtratoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/extratos")
@RequiredArgsConstructor
public class ExtratoController {
    private final ExtratoService extratoService;

    @GetMapping("/{numeroConta}")
    public ResponseEntity<List<ExtratoResponseDTO>> buscarExtrato(@PathVariable String numeroConta) {
        List<ExtratoResponseDTO> extrato = extratoService.buscarExtrato(numeroConta);
        return ResponseEntity.ok(extrato);
    }
}