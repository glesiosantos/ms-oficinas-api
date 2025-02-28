package br.com.mumec.msoficinas.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {

    PROP("Proprietário"),
    ATEN("Atendente"),
    MECA("Mecânico");

    private final String nome;
}
