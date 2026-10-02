package com.magioli.desafiobackenditau.transacao.service.impl;

import com.magioli.desafiobackenditau.dto.TransacaoDto;
import com.magioli.desafiobackenditau.entity.Transacao;
import com.magioli.desafiobackenditau.exception.criada.ArgumentoInvalidoException;
import com.magioli.desafiobackenditau.repository.TransacaoRepositoryInterface;
import com.magioli.desafiobackenditau.transacao.service.TransacaoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacaoService implements TransacaoServiceInterface {

    private final TransacaoRepositoryInterface transacaoRepository;

    @Override
    public List<TransacaoDto> obterTransacoes() {
        List<TransacaoDto> transacaoDtos = transacaoRepository.obterTransacoes()
                .stream()
                .map(this::converterTransacaoParaDto)
                .collect(Collectors.toList());
        return transacaoDtos;
    }

    @Override
    public void salvar(TransacaoDto transacaoDto) {
        if (OffsetDateTime.now().isBefore(transacaoDto.dataHora())) {
            throw new ArgumentoInvalidoException("A transação está com tempo futuro");
        }
        if (transacaoDto.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ArgumentoInvalidoException("O valor da transação deve ser maior que 0");
        }
        Transacao transacao = converterTransacaoDtoParaEntidade(transacaoDto);
        transacaoRepository.salvar(transacao);
    }

    @Override
    public void limparTransacoes() {
        transacaoRepository.limparTransacoes();
    }

    private Transacao converterTransacaoDtoParaEntidade(TransacaoDto transacaoDto) {
        Transacao transacao = new Transacao();
        BeanUtils.copyProperties(transacaoDto, transacao);
        return transacao;
    }

    private TransacaoDto converterTransacaoParaDto(Transacao transacao) {
        return new TransacaoDto(transacao.getValor(), transacao.getDataHora());
    }
}
