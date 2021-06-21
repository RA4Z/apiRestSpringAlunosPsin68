package br.com.senai.api.controller;


import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;
    private PessoaAssembler pessoaAssembler;

    @GetMapping()
    public List<PessoaModel> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<PessoaModel> listarPorNome(@PathVariable String pessoaNome){
        return pessoaService.listarPorNome(pessoaNome);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<PessoaModel> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaService.listarNomeContaining(nomeContaining);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaModel> buscar(@PathVariable Long pessoaId){
        return pessoaService.pesquisa(pessoaId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel cadastrar(@Valid @RequestBody PessoaInput pessoaInput){
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        Pessoa pessoa = pessoaService.cadastrar(novaPessoa);

        return pessoaAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel editar(@Valid @RequestBody PessoaInput pessoaInput, @PathVariable Long pessoaId){
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaInput);
        ResponseEntity<Pessoa> pessoaResponseEntity = pessoaService.editar(pessoaId, novaPessoa);

        return pessoaAssembler.toModel(pessoaResponseEntity.getBody());
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<PessoaModel> remover(@Valid @PathVariable Long pessoaId) {

        pessoaService.excluir(pessoaId);

        return ResponseEntity.noContent().build();
    }

}