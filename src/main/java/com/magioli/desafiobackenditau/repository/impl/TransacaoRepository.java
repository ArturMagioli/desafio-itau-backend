package com.magioli.desafiobackenditau.repository.impl;

import com.magioli.desafiobackenditau.entity.Transacao;
import com.magioli.desafiobackenditau.repository.TransacaoRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository implements TransacaoRepositoryInterface {

    private final List<Transacao> transacoes = new ArrayList<>();

    @Override
    public List<Transacao> obterTransacoes() {
        return transacoes;
    }

    @Override
    public void salvar(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    @Override
    public void limparTransacoes() {
        this.transacoes.clear();
    }
}
