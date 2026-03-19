package dev.datanorte.DesafioItau.controllers;

import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import dev.datanorte.DesafioItau.repository.TransacaoRepository;
import dev.datanorte.DesafioItau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    private TransacaoRepository transacaoRepository;

    public TransacoesController(TransacaoRepository transacaoRepository, TransacaoService transacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoService = transacaoService;
    }

    private TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.validarTransacao(transacaoDTO);
            transacaoRepository.salvarDados(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @DeleteMapping
    public ResponseEntity<Void> excluir(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.validarTransacao(transacaoDTO);
            return  ResponseEntity.status(HttpStatus.OK).build();

        }catch (IllegalArgumentException e){
            return ResponseEntity.status(422).build();
        }
    }

}
