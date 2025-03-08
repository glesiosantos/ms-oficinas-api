package br.com.msoficinas.api.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record FornecedorRequest(
        Long idFornecedor,
        @NotBlank(message = "Nome do fornecedor é obrigatório") String nomeFornecedor,
        @NotEmpty(message = "Contato não pode ser vazio") List<String> contatos,
        @NotEmpty(message = "ID do estabelecimento é obrigatório") Long idEstabelecimento
) {}
