package br.com.mumec.msoficinas.api.repositories;

import br.com.mumec.msoficinas.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.estabelecimentos WHERE u.id = :id")
    Optional<Usuario> findUsuarioByEstabelecimentoId(@Param("id") Long id);

    @Query("SELECT u FROM Usuario u JOIN FETCH u.estabelecimentos WHERE u.cpf = :cpf")
    Optional<Usuario> findByCpfComEstabelecimentos(@Param("cpf") String cpf);
}
