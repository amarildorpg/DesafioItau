package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import dev.datanorte.DesafioItau.repository.TransacaoRepository;
import dev.datanorte.DesafioItau.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    private final TransacaoRepository transacaoRepository;
    private final TransacaoService transacaoService;

    public TransacoesController(TransacaoRepository transacaoRepository, TransacaoService transacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacaoDTO) {
        log.info("Adicionando transação");
        try {
            transacaoService.validarTransacao(transacaoDTO);
            transacaoRepository.salvarDados(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            log.error("Erro e uma ou mais validações, tente novamente");
            return ResponseEntity.status(422).build();
        } catch (Exception e){
            log.error("Erro no servidor, tente novamente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @DeleteMapping
    public ResponseEntity<Void> deletar() {
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
