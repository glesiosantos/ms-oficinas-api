package br.com.mumec.msoficinas.api.services;

import br.com.mumec.msoficinas.api.entidades.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario buscarUsuarioPeloCpf(String cpf) throws Exception;

    List<Usuario> carregarUsuarioPeloEstabelecimento(Long idEstabelecimento);
}
