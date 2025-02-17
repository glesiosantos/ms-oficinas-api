package br.com.mumec.msoficinas.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estabelecimentos")
public class Estabelecimento extends Auditoria {

    @Column(name = "cpf_cnpj", length = 15, nullable = false, unique = true)
    private String cpfOuCnpj;

    @Column(name = "razao", length = 150, nullable = false, unique = true)
    private String razaoSocial;

    @Column(name = "nm_fantasia", length = 150, nullable = false)
    private String nomeFantasia;

    @Column(columnDefinition = "BOOLEAN default 'false'")
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_estabelecimento_contatos",
            joinColumns = @JoinColumn(name = "estabelecimento_id"))
    private Set<String> contatos;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabelecimento")
    private List<Usuario> usuarios;
}
