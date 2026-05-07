package com.danieldev.api.controller;

import com.danieldev.api.dto.request.DepositoRequestDTO;
import com.danieldev.api.dto.request.SaqueRequestDTO;
import com.danieldev.api.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@RequestBody DepositoRequestDTO dto) {
        transacaoService.depositar(dto.getNumeroConta(), dto.getValor());
        return ResponseEntity.ok("Depósito realizado");
    }

    @PostMapping("/saque")
    public ResponseEntity<String> sacar(@RequestBody SaqueRequestDTO dto) {
        transacaoService.sacar(dto.getNumeroConta(), dto.getValor());
        return ResponseEntity.ok("Saque realizado");
    }
}
