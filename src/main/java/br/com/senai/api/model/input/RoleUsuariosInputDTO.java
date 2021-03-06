package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoleUsuariosInputDTO {

    @NotNull
    private long id;

    @NotNull
    private String nome;

}
