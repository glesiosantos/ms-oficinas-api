package br.com.msoficinas.api.services;

import br.com.msoficinas.api.entidades.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario buscarUsuarioPeloCpf(String cpf) throws Exception;

    List<Usuario> carregarUsuarioPeloEstabelecimento(Long idEstabelecimento);
}
