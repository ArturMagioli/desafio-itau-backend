package com.magioli.desafiobackenditau.repository;

import com.magioli.desafiobackenditau.entity.Transacao;

import java.util.List;

public interface TransacaoRepositoryInterface {

    List<Transacao> obterTransacoes();

    void salvar(Transacao transacao);

}
