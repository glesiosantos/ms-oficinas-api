package br.com.mumec.msoficinas.api.services.impl;

import br.com.mumec.msoficinas.api.entidades.Estabelecimento;
import br.com.mumec.msoficinas.api.entidades.Usuario;
import br.com.mumec.msoficinas.api.enuns.Perfil;
import br.com.mumec.msoficinas.api.repositories.EstabelecimentoRepository;
import br.com.mumec.msoficinas.api.services.EstabelecimentoService;
import br.com.mumec.msoficinas.api.services.exceptions.ObjetoJaRegistradoException;
import br.com.mumec.msoficinas.api.web.mappers.EstabelecimentoMapper;
import br.com.mumec.msoficinas.api.web.request.EstabelecimentoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private EstabelecimentoMapper estabelecimentoMapper;

    @Override
    public Estabelecimento cadastrarEstabelecimento(EstabelecimentoRequest request) throws Exception {

        Optional<Estabelecimento> optional = estabelecimentoRepository.findByCpfOuCnpj(request.cpfOuCnpj());

        if(optional.isPresent()) throw new ObjetoJaRegistradoException("Estabelecimento já registrado em nossa base");

        var estabelecimento = estabelecimentoMapper.converterRequestParaModel(request);
        var usuario = Usuario.builder()
                .nomeCompleto(request.proprietario())
                .cpf(request.cpfProprietario())
                .ativo(true)
                .senha(request.cpfProprietario())
                .perfil(Perfil.PROP)
                .estabelecimento(estabelecimento)
                .build();

        estabelecimento.setUsuarios(Collections.singletonList(usuario));

        return estabelecimentoRepository.save(estabelecimento);
    }
}
