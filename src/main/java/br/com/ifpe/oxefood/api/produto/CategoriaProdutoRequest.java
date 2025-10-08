package br.com.ifpe.oxefood.api.produto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
public class CategoriaProdutoRequest {

    private String descricao;

    public CategoriaProduto build() {

        return CategoriaProduto.builder()
        .descricao(descricao)
        .build();

    }

}
