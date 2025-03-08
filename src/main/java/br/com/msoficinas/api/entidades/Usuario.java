package br.com.msoficinas.api.entidades;

import br.com.msoficinas.api.enuns.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Auditoria {

    @Column(name = "avatar", length = 150, columnDefinition = "VARCHAR(150) default 'default.png'")
    private String avatar;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "nm_completo", length = 150, nullable = false)
    private String nomeCompleto;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Column(length = 150, nullable = false)
    private String senha;

    @Column(columnDefinition = "BOOLEAN default 'false'")
    private boolean ativo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_estabelecimento",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "estabelecimento_id"))
    private Set<Estabelecimento> estabelecimentos = new HashSet<>();
}
