package br.com.msoficinas.api.services;

import br.com.msoficinas.api.entidades.Fornecedor;
import br.com.msoficinas.api.web.request.FornecedorRequest;

import java.util.List;

public interface FornecedorService {
    Fornecedor salvarFornecedorDoEstabelecimento(FornecedorRequest request) throws Exception;

    List<Fornecedor> carregarFornecedoresPeloEstabelecimento(Long idEstabelecimento);

    void excluirFornecedorDoEstabelecimento(Long idFornecedor);
}
