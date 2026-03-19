package dev.datanorte.DesafioItau.service;

import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    public  void validarTransacao(TransacaoDTO transacaoDTO){
    // valor Maior igual a 0

        if (transacaoDTO.getValor() == null) {
            throw new IllegalArgumentException("Erro: valor é obrigatório");
        }
        if (transacaoDTO.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: dataHora é obrigatória");
        }
        if (transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: isso não é uma transação válida");
        }
        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: dataHora não pode ser no futuro\"");
        }
    }
}
