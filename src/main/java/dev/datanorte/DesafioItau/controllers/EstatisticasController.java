package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.properties.EstatisticaProperties;
import dev.datanorte.DesafioItau.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;

@Slf4j
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
        log.info("Calculando estatísticas");
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(properties.segundos());
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }


}
