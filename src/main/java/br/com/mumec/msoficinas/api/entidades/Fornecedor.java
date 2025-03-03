package br.com.mumec.msoficinas.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedores")
public class Fornecedor extends EntidadeAbstrata{

    @Column(name = "nm_fornecedor", nullable = false)
    private String nomeFornecedor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @ElementCollection
    @JoinTable(name = "fornecedor_estabelecimento")
    private List<String> contatos;
}
