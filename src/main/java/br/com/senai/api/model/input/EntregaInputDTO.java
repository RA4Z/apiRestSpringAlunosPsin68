package br.com.senai.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EntregaInputDTO {

    @NotNull
    @Valid
    PessoaIdInputDTO pessoa;

    @NotNull
    @Valid
    DestinatarioInputDTO destinatario;

    @NotNull
    BigDecimal taxa;
}
