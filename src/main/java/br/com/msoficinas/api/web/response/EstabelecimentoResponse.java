package br.com.msoficinas.api.web.response;

public record EstabelecimentoResponse(
        Long idEstabelecimento,
        String logo,
        String nomeEstabelecimento
){}
