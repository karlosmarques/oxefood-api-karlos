package br.com.ifpe.oxefood.api.cidade;

import java.time.LocalDate;
import java.util.List;

public record CidadeRequest(String nome,Integer qtdPopulacao, Boolean ehCapital,LocalDate dataFundacao) {
} 
    

