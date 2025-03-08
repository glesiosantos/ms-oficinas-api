package br.com.msoficinas.api.web.response;

import java.util.List;

public record LoginResponse (
        String token,
        List<EstabelecimentoResponse> estabelecimentos,
        String nome,
        String perfil
){}
