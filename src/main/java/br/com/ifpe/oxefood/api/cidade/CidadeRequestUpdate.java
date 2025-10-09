package br.com.ifpe.oxefood.api.cidade;

import java.time.LocalDate;

public record CidadeRequestUpdate(String nome,Integer qtdPopulacao, Boolean ehCapital,LocalDate dataFundacao) {
} 
    

