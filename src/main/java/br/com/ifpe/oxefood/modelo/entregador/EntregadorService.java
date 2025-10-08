package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class EntregadorService {
    
    @Autowired // injetar uma depedencia auto / inicializar um atributo de uma classe
   private EntregadorRepository repository;

   @Transactional // criar um bloco transacional 
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
   }
  public List<Entregador> listarTodos() {
  
        return repository.findAll();
    }
 
  @Transactional
   public void update(Long id, Entregador entregadorAlterado) {

      Entregador entregador = repository.findById(id).get();
      entregador.setNome(entregadorAlterado.getNome());
      entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
      entregador.setCpf(entregadorAlterado.getCpf());
      entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
      entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
      entregador.setRg(entregadorAlterado.getRg());
      entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
      entregador.setValorFrete(entregadorAlterado.getValorFrete());
      entregador.setRua(entregadorAlterado.getRua());
      entregador.setNumero(entregadorAlterado.getNumero());
      entregador.setBairro(entregador.getBairro());
      entregador.setCidade(entregadorAlterado.getCidade());
      entregador.setCep(entregadorAlterado.getCep());
      entregador.setUf(entregadorAlterado.getUf());
      entregador.setComplemento(entregadorAlterado.getComplemento());
	    
      repository.save(entregador);
  }
@Transactional
   public void delete(Long id) {

       Entregador entregador = repository.findById(id).get();
       entregador.setHabilitado(Boolean.FALSE);

       repository.save(entregador);
   }

   

}

