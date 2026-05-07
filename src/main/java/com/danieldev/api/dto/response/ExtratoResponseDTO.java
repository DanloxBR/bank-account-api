package com.danieldev.api.dto.response;

import com.danieldev.api.entity.TipoTransacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ExtratoResponseDTO {
    private TipoTransacao tipo;
    private BigDecimal valor;
    private LocalDateTime data;
}
