package br.com.senai.api.controller;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private PessoaService pessoaService;
    private PessoaAssembler pessoaAssembler;

    @GetMapping()
    public List<Pessoa> listar() {
        return pessoaService.listar();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<Pessoa> listarPorNome(@PathVariable String pessoaNome) {
        return pessoaService.listarPorNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<Pessoa> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaService.listarNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public Pessoa buscar(@PathVariable Long pessoaId) {
        return pessoaService.buscar(pessoaId);
    }

    @PostMapping
    public PessoaModel cadastrar(@Valid @RequestBody PessoaInput pessoaInput) {
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        Pessoa pessoa = pessoaService.cadastrar(novaPessoa);

        return pessoaAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> editar(@Valid @PathVariable Long pessoaId,@RequestBody Pessoa pessoa){
        return pessoaService.editar(pessoaId, pessoa);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Object> remover(@PathVariable Long pessoaId){
        return pessoaService.excluir(pessoaId);
    }
}