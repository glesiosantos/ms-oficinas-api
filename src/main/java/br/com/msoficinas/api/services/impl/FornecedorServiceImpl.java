package br.com.msoficinas.api.services.impl;

import br.com.msoficinas.api.entidades.Fornecedor;
import br.com.msoficinas.api.repositories.FornecedorRepository;
import br.com.msoficinas.api.services.EstabelecimentoService;
import br.com.msoficinas.api.services.FornecedorService;
import br.com.msoficinas.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.msoficinas.api.web.mappers.FornecedorMapper;
import br.com.msoficinas.api.web.request.FornecedorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @Override
    public Fornecedor salvarFornecedorDoEstabelecimento(FornecedorRequest request) throws Exception {
        var estabelecimento = estabelecimentoService.buscarEstabelecimentoPeloId(request.idEstabelecimento());
        Fornecedor fornecedor = fornecedorMapper.converterRequestParaModelo(request);
        fornecedor.setEstabelecimento(estabelecimento);
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> carregarFornecedoresPeloEstabelecimento(Long idEstabelecimento) {
        return fornecedorRepository.findFornecedoresByEstabelecimento(idEstabelecimento);
    }

    @Override
    public void excluirFornecedorDoEstabelecimento(Long idEstabelecimento, Long idFornecedor)  throws Exception{
        var fornecedor = fornecedorRepository.findByIdAndEstabelecimentoId(idFornecedor, idEstabelecimento).orElseThrow(
                () -> new ObjetoNaoEncontradoException(String.format("Nenhum fornecedor encontrado com este código %s", idFornecedor))
        );
        fornecedorRepository.delete(fornecedor);
    }
}
