package br.com.senai.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PessoaInput {

    @NotNull
    long id;

    @NotNull
    String nome;

    @NotNull
    String email;

    @NotNull
    String telefone;

}
