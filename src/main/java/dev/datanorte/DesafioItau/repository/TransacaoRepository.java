package dev.datanorte.DesafioItau.repository;

import dev.datanorte.DesafioItau.dto.EstatisticaDTO;
import dev.datanorte.DesafioItau.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacaoRepository {
    List<TransacaoDTO> listaTransacoes= new ArrayList<>();
    //Salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO) {
        listaTransacoes.add(transacaoDTO);
    }

    //Apagar essa lista após 60 segundos
    public void limparDados(){

    }

    //Apagar todas as transações da lista
    public void deletarDados(){
        listaTransacoes.clear();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){
        if (listaTransacoes.isEmpty()){
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }
        final var summary = listaTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();
        return new EstatisticaDTO(summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum());
    }
}
