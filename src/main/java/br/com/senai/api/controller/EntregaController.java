package br.com.senai.api.controller;

import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entregas) {
       return solicitacaoEntregaService.solicitar(entregas);
    }
    @GetMapping
    public List<Entrega> listar() {
        return solicitacaoEntregaService.listar();
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
        return solicitacaoEntregaService.buscar(entregaId);
    }
}
