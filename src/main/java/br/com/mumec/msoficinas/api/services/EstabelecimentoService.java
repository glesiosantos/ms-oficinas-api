package br.com.mumec.msoficinas.api.services;

import br.com.mumec.msoficinas.api.entidades.Estabelecimento;
import br.com.mumec.msoficinas.api.web.request.EstabelecimentoRequest;

public interface EstabelecimentoService {

    Estabelecimento cadastrarEstabelecimento(EstabelecimentoRequest request) throws Exception;
}
