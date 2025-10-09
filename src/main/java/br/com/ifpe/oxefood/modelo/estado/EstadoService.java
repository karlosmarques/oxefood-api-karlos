package br.com.ifpe.oxefood.modelo.estado;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ifpe.oxefood.api.Estado.EstadoRequest;
import br.com.ifpe.oxefood.api.Estado.EstadoResquestUpdate;
import lombok.experimental.var;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repository;

    public Estado addestado(EstadoRequest request){
       var Entity = Estado.builder()
       .nome(request.nome())
       .sigla(request.sigla())
       .build();
       return repository.save(Entity);
    }

    public List<Estado> listAll(){
        return repository.findAll();
    }

   public Optional<Estado> filtrarPorId(long estadoid){
        return repository.findById(estadoid);
   }


    public void deletarPorId(long estadoid){
     repository.deleteById(estadoid);
  }

public Estado updateEstado(long estadoid, EstadoResquestUpdate request){
    var estadoEntity = repository.findById(estadoid);
    if (estadoEntity.isPresent()) {
        var estado = estadoEntity.get();

        if (request.nome() !=null) {
            estado.setNome(request.nome());
        }
         if (request.sigla() !=null) {
            estado.setSigla(request.sigla());
        }
         return repository.save(estado);
    }
    return null;
  }

}

