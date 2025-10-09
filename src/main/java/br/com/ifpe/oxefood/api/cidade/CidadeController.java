package br.com.ifpe.oxefood.api.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cidade.Cidade;
import br.com.ifpe.oxefood.modelo.cidade.CidadeServce;
import br.com.ifpe.oxefood.modelo.estado.EstadoRepository;

@RestController
@RequestMapping("api/cidade")
public class CidadeController {
    
    @Autowired
    private CidadeServce cidadeServce;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping()
    public ResponseEntity<Cidade> addCidade(@RequestBody CidadeRequest request){
        var criado = cidadeServce.addCidade(request);
        return ResponseEntity.ok(criado);
        
    }

    @GetMapping("/listar")
    public ResponseEntity <List<Cidade>> listarCidades(){
        var cidades = cidadeServce.listarCidades();
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{cidadeid}")
    public ResponseEntity<Cidade> filtrarPorId(@PathVariable Long cidadeid){
        var cidade = cidadeServce.filtrarPorId(cidadeid);
        return ResponseEntity.ok(cidade.get());
       
    }

    @DeleteMapping("/{cidadeid}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long cidadeid){
        cidadeServce.deletarPorId(cidadeid);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{cidadeid}")
    public ResponseEntity<Cidade> updateCidade(@PathVariable long cidadeid ,@RequestBody CidadeRequestUpdate request){
        var cidade = cidadeServce.updateCidade(cidadeid,request);
        return ResponseEntity.ok(cidade);
      
    }

}
