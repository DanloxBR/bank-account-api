package com.danieldev.api.controller;

import com.danieldev.api.dto.request.ContaRequestDTO;
import com.danieldev.api.entity.Conta;
import com.danieldev.api.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {
    private final ContaService contaService;

    @GetMapping("/{numeroConta}/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable String numeroConta) {
        return ResponseEntity.ok(contaService.consultarSaldo(numeroConta));
    }

    @PostMapping
    public ResponseEntity<Conta> criarConta(
            @RequestBody @Valid ContaRequestDTO dto
    ) {

        return ResponseEntity.ok(
                contaService.criarConta(dto)
        );
    }
}
