package br.com.senai.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PessoaModel {

    @NotNull
    Long id;

    String nomePessoa;
    String emailPessoa;
    String telefone;
}
