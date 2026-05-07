package com.danieldev.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DepositoRequestDTO {
    @NotBlank
    private String numeroConta;

    @NotNull(message = "Valor obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve ser maior que zero")
    private BigDecimal valor;
}