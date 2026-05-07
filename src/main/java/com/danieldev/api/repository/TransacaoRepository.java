package com.danieldev.api.repository;

import com.danieldev.api.entity.Conta;
import com.danieldev.api.entity.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByConta(Conta conta);
}
