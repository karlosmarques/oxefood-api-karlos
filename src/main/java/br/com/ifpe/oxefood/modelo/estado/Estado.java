package br.com.ifpe.oxefood.modelo.estado;

import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cidade") 
@Builder
@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@NoArgsConstructor
public class Estado extends EntidadeAuditavel  {


   @Column
   private String nome;

   @Column 
   private String sigla;


}

