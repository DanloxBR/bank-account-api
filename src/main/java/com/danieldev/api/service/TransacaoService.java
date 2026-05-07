package com.danieldev.api.service;

import com.danieldev.api.entity.Conta;
import com.danieldev.api.entity.TipoTransacao;
import com.danieldev.api.entity.Transacao;
import com.danieldev.api.exception.ContaNaoEncontradaException;
import com.danieldev.api.exception.SaldoInsuficienteException;
import com.danieldev.api.repository.ContaRepository;
import com.danieldev.api.repository.TransacaoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    @Transactional
    public void depositar(String numeroConta, BigDecimal valor) {
        Conta conta = contaRepository
                .findByNumeroConta(numeroConta)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada"));
        conta.setSaldo(conta.getSaldo().add(valor));
        contaRepository.save(conta);
        salvarTransacao(conta, valor, TipoTransacao.DEPOSITO);
    }

    @Transactional
    public void sacar(String numeroConta, BigDecimal valor) {
        Conta conta = contaRepository
                .findByNumeroConta(numeroConta)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada"));
        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
        salvarTransacao(conta, valor, TipoTransacao.SAQUE);
    }

    private void salvarTransacao(Conta conta, BigDecimal valor, TipoTransacao tipo) {
        Transacao transacao = new Transacao();
        transacao.setConta(conta);
        transacao.setValor(valor);
        transacao.setTipo(tipo);
        transacao.setData(LocalDateTime.now());
        transacaoRepository.save(transacao);
    }
}