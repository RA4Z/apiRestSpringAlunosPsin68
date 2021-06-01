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
@RequestMapping("/consultor")
public class ConsultorController {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private ConsultorRepository consultorRepository;

    @GetMapping()
    public List<Consultor> listar() {
//        return entityManager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
        return consultorRepository.findAll();
    }
    @GetMapping("/nome/{consultorNome}")
    public List<Consultor> listarPorNome(@PathVariable String pessoaNome) {
        return consultorRepository.findByNome(pessoaNome);
    }
    @GetMapping("/nome/containing/{nomeContaining}")
    public List<Consultor> listarNomeContaining(@PathVariable String nomeContaining) {
        return consultorRepository.findByNomeContaining(nomeContaining);
    }

    @GetMapping("{consultorId}")
    public ResponseEntity<Consultor> buscar(@PathVariable Long consultorId) {
//        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
//        if(pessoa.isPresent()) {
//            return ResponseEntity.ok(pessoa.get());
//        }
//        return ResponseEntity.notFound().build();
        return consultorRepository.findById(consultorId)
                .map(consultor -> ResponseEntity.ok(consultor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consultor cadastrar(@Valid @RequestBody Consultor consultor) {
        return consultorRepository.save(consultor);
    }

    @PutMapping("/{consultorId}")
    public ResponseEntity<Consultor> editar(
            @Valid @PathVariable Long consultorId,
            @RequestBody Consultor consultor
    ){
        if(!consultorRepository.existsById(consultorId)) {
            return ResponseEntity.notFound().build();
        }

        consultor.setId(consultorId);
        consultor = consultorRepository.save(consultor);

        return ResponseEntity.ok(consultor);
    }

    @DeleteMapping("/{consultorId}")
    public ResponseEntity<Consultor> remover(@PathVariable Long consultorId){

        if(!consultorRepository.existsById(consultorId)) {
            return ResponseEntity.notFound().build();
        }
        consultorRepository.deleteById(consultorId);

        return ResponseEntity.noContent().build();
    }
}
