package br.com.ifpe.oxefood.api.Estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.estado.Estado;
import br.com.ifpe.oxefood.modelo.estado.EstadoService;
import lombok.var;




@RestController
@RequestMapping("/api/Estado")
@CrossOrigin
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @PostMapping()
    public ResponseEntity<Estado> addestado(@RequestBody EstadoRequest request) {
        var criado = estadoService.addestado(request);
        return ResponseEntity.ok(criado);
    }
    
    @GetMapping("/listar")
    public ResponseEntity <List<Estado>> listAll() {
       var lista = estadoService.listAll();
       return ResponseEntity.ok(lista);
       
    }

     @GetMapping("/{estadoid}")
    public ResponseEntity<Estado> filtrarPorId(@PathVariable Long estadoid){
        var caixa = estadoService.filtrarPorId(estadoid);
        return ResponseEntity.ok(caixa.get());
       
    }
    @DeleteMapping("/{estadoid}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long estadoid){
        estadoService.deletarPorId(estadoid);
        return ResponseEntity.noContent().build();

    }

     @PatchMapping("/{estadoid}")
    public ResponseEntity<Estado> updateEstado(@PathVariable long estadoid ,@RequestBody EstadoResquestUpdate request){
        var estado = estadoService.updateEstado(estadoid,request);
        return ResponseEntity.ok(estado);
    }

}
