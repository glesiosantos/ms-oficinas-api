package br.com.mumec.msoficinas.api.web.request;

public record EstabelecimentoRequest(
        String cpfOuCnpj,
        String razaoSocial,
        String nomeFantasia,
        String cpfProprietario,
        String proprietario,
        boolean ativo,
        int vencimento,
        String cep,
        String plano,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude
) {}
