package br.com.mumec.msoficinas.api.web.request;

public record EstabelecimentoRequest(
        String cpfOuCnpj,
        String razaoSocial,
        String nomeFantasia,
        String cpfProprietario,
        String proprietario,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude
) {}
