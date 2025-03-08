package br.com.msoficinas.api.web.request;

public record LoginRequest(
   String cpf,
   String senha
) {}
