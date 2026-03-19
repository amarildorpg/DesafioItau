package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import dev.datanorte.DesafioItau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    private final TransacaoService transacaoService;
    public TransacoesController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.validarTransacao(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).build();
        }

    }

}
