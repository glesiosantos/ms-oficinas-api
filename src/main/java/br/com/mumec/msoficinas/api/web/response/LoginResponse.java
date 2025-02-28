package br.com.mumec.msoficinas.api.web.response;

import java.util.List;

public record LoginResponse (
        String token,
        List<EstabelecimentoLoginResponse> estabelecimentos,
        String cpf,
        String nome
){}
