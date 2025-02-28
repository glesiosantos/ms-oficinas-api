package br.com.mumec.msoficinas.api.services.impl;

import br.com.mumec.msoficinas.api.entidades.Usuario;
import br.com.mumec.msoficinas.api.repositories.UsuarioRepository;
import br.com.mumec.msoficinas.api.services.UsuarioService;
import br.com.mumec.msoficinas.api.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarUsuarioPeloCpf(String cpf) throws Exception {
        return usuarioRepository.findByCpfComEstabelecimentos(cpf).orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> carregarUsuarioPeloEstabelecimento(Long idEstabelecimento) {
        return List.of();
    }
}
