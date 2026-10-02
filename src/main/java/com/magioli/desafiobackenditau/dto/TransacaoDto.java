package com.magioli.desafiobackenditau.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoDto (
        @NotNull(message = "É necessário informar um valor.")
        BigDecimal valor,

        @NotNull(message = "É necessário fornecer uma data com hora")
        OffsetDateTime dataHora
)
{}
