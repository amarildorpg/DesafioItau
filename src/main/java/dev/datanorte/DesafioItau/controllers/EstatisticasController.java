package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.properties.EstatisticaProperties;
import dev.datanorte.DesafioItau.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {
    private final EstatisticaProperties properties;
    private final TransacaoRepository transacaoRepository;
    public EstatisticasController(EstatisticaProperties properties, TransacaoRepository transacaoRepository) {
        this.properties = properties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<?> estatisticas() {
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(properties.segundos());
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }


}
