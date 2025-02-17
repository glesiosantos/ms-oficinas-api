package br.com.mumec.msoficinas.api.repositories;

import br.com.mumec.msoficinas.api.entidades.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Optional<Estabelecimento> findByCpfOuCnpj(String s);
}
