package br.com.mumec.msoficinas.api.services.impl;

import br.com.mumec.msoficinas.api.entidades.Fornecedor;
import br.com.mumec.msoficinas.api.repositories.FornecedorRepository;
import br.com.mumec.msoficinas.api.services.EstabelecimentoService;
import br.com.mumec.msoficinas.api.services.FornecedorService;
import br.com.mumec.msoficinas.api.web.mappers.FornecedorMapper;
import br.com.mumec.msoficinas.api.web.request.FornecedorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @Override
    public Fornecedor salvarFornecedor(FornecedorRequest request) throws Exception {
        var estabelecimento = estabelecimentoService.carregarEstabelecimento(request.idEstabelecimento());
        var fornecedor = fornecedorMapper.converterRequestParaModelo(request);
        fornecedor.setEstabelecimento(estabelecimento);
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> carregarFornecedoresPeloEstabelecimento(Long estabelecimentoId) {
        return fornecedorRepository.findFornecedoresByEstabelecimento(estabelecimentoId);
    }

    @Override
    public void excluirFornecedor(Long idFornecedor, Long estabelecimentoId) {}
}
