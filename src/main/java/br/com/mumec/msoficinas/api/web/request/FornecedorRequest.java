package br.com.mumec.msoficinas.api.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FornecedorRequest(
        Long idFornecedor,
        @NotBlank(message = "Nome do Fornecedor é obrigatório") String nomeFornecedor,
        @NotNull(message = "Estabelecimento é obrigatório") Long idEstabelecimento,
        @NotNull(message = "precisa pelo um contato para registrar") List<String> contatos
) {}
