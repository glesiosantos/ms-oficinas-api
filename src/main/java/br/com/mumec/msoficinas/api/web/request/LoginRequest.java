package br.com.mumec.msoficinas.api.web.request;

public record LoginRequest(
   String cpf,
   String senha
) {}
