package br.com.senai.api.model.input;

import br.com.senai.api.model.PessoaModel;
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
public class EntregaInput {

    @NotNull
    @Valid
    PessoaModel pessoa;

    @NotNull
    @Valid
    DestinatarioInput destinatario;

    @NotNull
    BigDecimal taxa;
}
