package com.danieldev.api.service;

import com.danieldev.api.dto.request.ContaRequestDTO;
import com.danieldev.api.entity.Conta;
import com.danieldev.api.entity.Usuario;
import com.danieldev.api.exception.ContaNaoEncontradaException;
import com.danieldev.api.repository.ContaRepository;
import com.danieldev.api.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final UsuarioRepository usuarioRepository;

    public Conta buscarConta(String numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta).orElseThrow(() ->
                        new ContaNaoEncontradaException("Conta não encontrada"));
    }

    public BigDecimal consultarSaldo(String numeroConta) {
        Conta conta = buscarConta(numeroConta);
        return conta.getSaldo();
    }

    @Transactional
    public Conta criarConta(ContaRequestDTO dto) {
        Usuario usuario = usuarioRepository
                .findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Conta conta = new Conta();
        conta.setNumeroConta(dto.getNumeroConta());
        conta.setSaldo(dto.getSaldo());
        conta.setUsuario(usuario);
        return contaRepository.save(conta);
    }
}