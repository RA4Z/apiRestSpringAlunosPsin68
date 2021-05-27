package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")
    public List<Pessoa> listar() {

        Pessoa pessoa1 = new Pessoa();

        pessoa1.setId(1L);
        pessoa1.setNome("RAZ");
        pessoa1.setEmail("RAZ@gmail.com");
        pessoa1.setTelefone("(47)99958-5728");

        Pessoa pessoa2 = new Pessoa(2L,"João","Jao@gmail.com","(51)4002-8922");

        return Arrays.asList(pessoa1,pessoa2);
    }

}
