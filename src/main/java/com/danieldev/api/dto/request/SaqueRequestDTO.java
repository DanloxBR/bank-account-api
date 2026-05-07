package com.danieldev.api.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaqueRequestDTO {
    @NotBlank(message = "Número da conta obrigatório")
    private String numeroConta;

    @NotNull(message = "Valor obrigatório")
    @DecimalMin(value = "0.01", message = "O valor do saque deve ser maior que zero")
    private BigDecimal valor;
}