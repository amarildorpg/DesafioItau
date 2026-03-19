package dev.datanorte.DesafioItau.repository;

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

    public void estatistica(OffsetDateTime horaInicial){

    }
}
