package br.com.msoficinas.api.repositories;

import br.com.msoficinas.api.entidades.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query("SELECT f FROM Fornecedor f JOIN FETCH f.estabelecimento e WHERE e.id = :idEstabelecimento")
    List<Fornecedor> findFornecedoresByEstabelecimento(Long idEstabelecimento);

    Optional<Fornecedor> findByIdAndEstabelecimentoId(Long id, Long estabelecimentoId);
}
