package br.com.mumec.msoficinas.api.services;

import br.com.mumec.msoficinas.api.web.request.LoginRequest;
import br.com.mumec.msoficinas.api.web.response.LoginResponse;

public interface AutenticacaoService {

    LoginResponse autenticar(LoginRequest request) throws Exception;

    boolean validarToken(String token);

    void alterarSenha();

    void recuperarSenha();
}
