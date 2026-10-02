package com.magioli.desafiobackenditau.transacao.service;

import com.magioli.desafiobackenditau.dto.TransacaoDto;

import java.util.List;

public interface TransacaoServiceInterface {

    List<TransacaoDto> obterTransacoes();

    void salvar(TransacaoDto transacaoDto);
}
