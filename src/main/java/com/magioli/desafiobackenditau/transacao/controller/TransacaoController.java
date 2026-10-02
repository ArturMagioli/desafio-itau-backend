package com.magioli.desafiobackenditau.transacao.controller;

import com.magioli.desafiobackenditau.dto.TransacaoDto;
import com.magioli.desafiobackenditau.transacao.service.TransacaoServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoServiceInterface transacaoService;

    @GetMapping
    ResponseEntity<List<TransacaoDto>> obterTransacoes() {
        List<TransacaoDto> transacoes = transacaoService.obterTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @PostMapping
    ResponseEntity<Void> receberTransacao(@RequestBody @Valid TransacaoDto transacao) {
        transacaoService.salvar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
