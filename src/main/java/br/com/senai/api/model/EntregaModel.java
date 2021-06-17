package br.com.senai.api.model;

import br.com.senai.domain.model.StatusEntrega;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EntregaModel {

    Long id;
    PessoaModel pessoa;
    DestinatarioModel destinatario;
    BigDecimal taxa;
    LocalDateTime dataPedido;
    LocalDateTime dataFinalizacao;
    StatusEntrega status;

}
