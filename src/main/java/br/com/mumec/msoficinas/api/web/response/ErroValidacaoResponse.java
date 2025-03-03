package br.com.mumec.msoficinas.api.web.response;

public record ErroValidacaoResponse(
        String campo,
        String mensagem
) {
}
