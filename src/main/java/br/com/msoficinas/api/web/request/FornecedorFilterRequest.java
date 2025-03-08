package br.com.msoficinas.api.web.request;

public record FornecedorFilterRequest(
        Long idFornecedor,
        Long idEstabelecimento
) {}
