package com.magioli.desafiobackenditau.dto;

import java.math.BigDecimal;

public record EstatisticaDto (
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max
)
{}
