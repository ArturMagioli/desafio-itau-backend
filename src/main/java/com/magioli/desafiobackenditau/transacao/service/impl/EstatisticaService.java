package com.magioli.desafiobackenditau.transacao.service.impl;

import com.magioli.desafiobackenditau.dto.EstatisticaDto;
import com.magioli.desafiobackenditau.entity.Transacao;
import com.magioli.desafiobackenditau.repository.TransacaoRepositoryInterface;
import com.magioli.desafiobackenditau.transacao.service.EstatisticaServiceInterface;
import com.magioli.desafiobackenditau.transacao.util.GeradorDeEstatisticas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticaService implements EstatisticaServiceInterface {

    private final TransacaoRepositoryInterface transacaoRepository;
    private final GeradorDeEstatisticas geradorDeEstatisticas;

    @Override
    public EstatisticaDto obterEstatisticas() {
        List<Transacao> transacoes = transacaoRepository.obterTransacoes();
        return geradorDeEstatisticas.calcularEstatisticas(transacoes);
    }
}
