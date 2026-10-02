package com.magioli.desafiobackenditau.transacao.controller;

import com.magioli.desafiobackenditau.dto.EstatisticaDto;
import com.magioli.desafiobackenditau.transacao.service.EstatisticaServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaServiceInterface estatisticaService;

    @GetMapping
    ResponseEntity<EstatisticaDto> obterEstatistica() {
        EstatisticaDto estatisticas = estatisticaService.obterEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }
}
