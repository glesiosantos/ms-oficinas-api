package br.com.msoficinas.api.web.request;

import jakarta.validation.constraints.NotEmpty;

public record FornecedorFilterRequest(
        @NotEmpty(message = "ID do fornecedor é obrigatório") Long idFornecedor,
        @NotEmpty(message = "ID do estabelecimento é obrigatório") Long idEstabelecimento
) {}
