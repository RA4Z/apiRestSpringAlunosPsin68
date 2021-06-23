package br.com.senai.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DestinatarioDTO {

    String nome;
    String logradouro;
    String numero;
    String complemento;
    String bairro;
}
