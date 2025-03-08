package br.com.msoficinas.api.repositories;

import br.com.msoficinas.api.entidades.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Optional<Estabelecimento> findByCpfOuCnpj(String cpfOuCnpj);

    @Query("SELECT e FROM Estabelecimento e JOIN FETCH e.usuarios WHERE e.id = :id")
    Optional<Estabelecimento> findByIdComUsuarios(@Param("id") Long id);
}
