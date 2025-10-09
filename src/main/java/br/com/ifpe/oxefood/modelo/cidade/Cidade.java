package br.com.ifpe.oxefood.modelo.cidade;

import java.time.LocalDate;

import java.util.List;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Table;
import br.com.ifpe.oxefood.modelo.estado.Estado;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cidade") 

@Builder
@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@NoArgsConstructor
public class Cidade extends EntidadeAuditavel  {

    //@OneToMany(mappedBy = "Cidade", orphanRemoval = true, fetch = FetchType.EAGER)
   //private List<Estado> estado;

   @Column 
   private String nome;

   @Column
   private Integer qtdPopulacao;

   @Column
   private Boolean ehCapital;
   
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataFundacao;

}

