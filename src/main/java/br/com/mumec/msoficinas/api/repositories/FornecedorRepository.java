package br.com.mumec.msoficinas.api.repositories;

import br.com.mumec.msoficinas.api.entidades.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query("SELECT f FROM Fornecedor f JOIN FETCH f.estabelecimento e WHERE e.id = :idEstabelecimento")
    List<Fornecedor> findFornecedoresByEstabelecimento(Long idEstabelecimento);
}
