package br.com.senai.api.controller;

import br.com.senai.domain.model.Consultor;
import br.com.senai.domain.repository.ConsultorRepository;
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
    private ConsultorRepository consultorRepository;

    @GetMapping()
    public List<Consultor> listar() {
//        return entityManager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
        return consultorRepository.findAll();
    }
    @GetMapping("/nome/{pessoaNome}")
    public List<Consultor> listarPorNome(@PathVariable String pessoaNome) {
        return consultorRepository.findByNome(pessoaNome);
    }
    @GetMapping("/nome/containing/{nomeContaining}")
    public List<Consultor> listarNomeContaining(@PathVariable String nomeContaining) {
        return consultorRepository.findByNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<Consultor> buscar(@PathVariable Long pessoaId) {
//        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
//        if(pessoa.isPresent()) {
//            return ResponseEntity.ok(pessoa.get());
//        }
//        return ResponseEntity.notFound().build();
        return consultorRepository.findById(pessoaId)
                .map(consultor -> ResponseEntity.ok(consultor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consultor cadastrar(@Valid @RequestBody Consultor consultor) {
        return consultorRepository.save(consultor);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Consultor> editar(
            @Valid @PathVariable Long pessoaId,
            @RequestBody Consultor consultor
    ){
        if(!consultorRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }

        consultor.setId(pessoaId);
        consultor = consultorRepository.save(consultor);

        return ResponseEntity.ok(consultor);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Consultor> remover(@PathVariable Long pessoaId){

        if(!consultorRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        consultorRepository.deleteById(pessoaId);

        return ResponseEntity.noContent().build();
    }
}
