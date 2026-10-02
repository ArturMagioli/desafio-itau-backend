package com.magioli.desafiobackenditau.transacao.util;

import com.magioli.desafiobackenditau.dto.EstatisticaDto;
import com.magioli.desafiobackenditau.entity.Transacao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeradorDeEstatisticas {

    private final int segundosRecentes = 600;

    public EstatisticaDto calcularEstatisticas(List<Transacao> transacoes) {
        List<BigDecimal> valoresRecentes = transacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(segundosRecentes)))
                .map(Transacao::getValor)
                .collect(Collectors.toUnmodifiableList());
        long count = valoresRecentes.size();
        BigDecimal sum = valoresRecentes.stream()
                .reduce(BigDecimal.ZERO, (v1, v2) -> v1.add(v2));
        BigDecimal avg = count != 0 ? sum.divide(BigDecimal.valueOf(count)) : BigDecimal.ZERO;
        BigDecimal min = valoresRecentes.stream()
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
        BigDecimal max = valoresRecentes.stream()
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
        return new EstatisticaDto(count, sum, avg, min, max);
    }
}
