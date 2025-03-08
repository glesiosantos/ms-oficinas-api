package br.com.msoficinas.api.services;

import br.com.msoficinas.api.entidades.Estabelecimento;
import br.com.msoficinas.api.web.request.EstabelecimentoRequest;

public interface EstabelecimentoService {

    Estabelecimento cadastrarEstabelecimento(EstabelecimentoRequest request) throws Exception;
}
