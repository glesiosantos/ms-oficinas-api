package br.com.mumec.msoficinas.api.services;

import br.com.mumec.msoficinas.api.entidades.Fornecedor;
import br.com.mumec.msoficinas.api.web.request.FornecedorRequest;

import java.util.List;

public interface FornecedorService {

    Fornecedor salvarFornecedor(FornecedorRequest request) throws Exception;

    List<Fornecedor> carregarFornecedoresPeloEstabelecimento(Long estabelecimentoId);

    void excluirFornecedor(Long idFornecedor, Long estabelecimentoId);
}
