package br.com.msoficinas.api.web.request;

import java.util.List;

public record FornecedorRequest(
        Long idFornecedor,
        String nomeFornecedor,
        List<String> contatos,
        Long idEstabelecimento
) {}
