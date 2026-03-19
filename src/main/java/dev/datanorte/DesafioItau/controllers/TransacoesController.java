package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacaoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
