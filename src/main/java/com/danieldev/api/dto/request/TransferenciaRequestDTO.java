package com.danieldev.api.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferenciaRequestDTO {
    @NotBlank(message = "Conta de origem obrigatória")
    private String contaOrigem;

    @NotBlank(message = "Conta de destino obrigatória")
    private String contaDestino;

    @NotNull(message = "Valor obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve ser maior que zero")
    private BigDecimal valor;
}
