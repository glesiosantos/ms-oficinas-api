package br.com.mumec.msoficinas.api.repositories;

import br.com.mumec.msoficinas.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
