package com.danieldev.api.service;

import com.danieldev.api.dto.response.ExtratoResponseDTO;
import com.danieldev.api.entity.Conta;
import com.danieldev.api.entity.Transacao;
import com.danieldev.api.exception.ContaNaoEncontradaException;
import com.danieldev.api.repository.ContaRepository;
import com.danieldev.api.repository.TransacaoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExtratoService {
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;
    public List<ExtratoResponseDTO> buscarExtrato(String numeroConta) {
        Conta conta = contaRepository.findByNumeroConta(numeroConta).orElseThrow(() ->
                        new ContaNaoEncontradaException("Conta não encontrada"));
        List<Transacao> transacoes = transacaoRepository.findByConta(conta);
        return transacoes.stream().map(transacao -> new ExtratoResponseDTO(
                                transacao.getTipo(),
                                transacao.getValor(),
                                transacao.getData())).collect(Collectors.toList());
    }
}