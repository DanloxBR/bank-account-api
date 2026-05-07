package com.danieldev.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ContaResponseDTO {
    private String numeroConta;
    private String nomeTitular;
    private BigDecimal saldo;
}
