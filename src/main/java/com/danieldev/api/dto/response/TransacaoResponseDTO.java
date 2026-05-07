package com.danieldev.api.dto.response;

import com.danieldev.api.entity.TipoTransacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TransacaoResponseDTO {
    private Long id;
    private TipoTransacao tipo;
    private BigDecimal valor;
    private String contaOrigem;
    private String contaDestino;
    private LocalDateTime data;
}
