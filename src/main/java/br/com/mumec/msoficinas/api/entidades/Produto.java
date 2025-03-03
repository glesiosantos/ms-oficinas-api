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
@Table(name = "produtos")
public class Produto extends EntidadeAbstrata {

    @Column(name = "nm_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricaoProduto;

    @Column(name = "preco_custo", nullable = false)
    private Double precoCusto;

    @Column(name = "preco_venda", nullable = false)
    private Double precoVenda;

    @Column(name = "margem_lucro", nullable = false)
    private int margemDeLucro;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @ElementCollection
    @JoinTable(name = "produto_imagem")
    List<String> imagensProduto;
}
