package br.com.msoficinas.api.services.impl;

import br.com.msoficinas.api.entidades.Usuario;
import br.com.msoficinas.api.repositories.UsuarioRepository;
import br.com.msoficinas.api.services.UsuarioService;
import br.com.msoficinas.api.services.exceptions.ObjetoNaoEncontradoException;
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
        return usuarioRepository.findByCpfComEstabelecimentos(cpf)
                .orElseThrow(() -> new ObjetoNaoEncontradoException(String.format("Nenhum usuário encontrado com este CPF %s", cpf)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> carregarUsuarioPeloEstabelecimento(Long idEstabelecimento) {
        return usuarioRepository.findUsuarioByEstabelecimentoId(idEstabelecimento);
    }
}
