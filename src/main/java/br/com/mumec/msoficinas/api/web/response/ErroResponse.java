package br.com.mumec.msoficinas.api.web.response;

public record ErroResponse(
        String mensagem,
        int status,
        long horario,
        String path
) {}
