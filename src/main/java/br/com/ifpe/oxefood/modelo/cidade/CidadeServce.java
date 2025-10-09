package br.com.ifpe.oxefood.modelo.cidade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.api.cidade.CidadeRequest;
import br.com.ifpe.oxefood.api.cidade.CidadeRequestUpdate;
import br.com.ifpe.oxefood.modelo.estado.EstadoRepository;

@Service
public class CidadeServce {


    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

  public Cidade addCidade(CidadeRequest request){
        var Entity = Cidade.builder()
        .nome(request.nome())
        .qtdPopulacao(request.qtdPopulacao())
        .ehCapital(request.ehCapital())
        .dataFundacao(request.dataFundacao())
        .build();

        return cidadeRepository.save(Entity);
    }

      public List<Cidade> listarCidades(){
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> filtrarPorId(Long cidadeid){
            var cidade = cidadeRepository.findById(cidadeid);
            return cidade;
        }

    public Cidade deletarPorId(Long cidadeid){
        cidadeRepository.deleteById(cidadeid);
        return null;
    }

        public Cidade updateCidade(Long cidadeid, CidadeRequestUpdate request){
        var cidadeEntity = cidadeRepository.findById(cidadeid);
        var cidade = cidadeEntity.get();
        cidade.setNome(request.nome());
        cidade.setQtdPopulacao(request.qtdPopulacao());
        cidade.setEhCapital(request.ehCapital());
        cidade.setDataFundacao(request.dataFundacao());
        return cidadeRepository.save(cidade);
        
    }
}
