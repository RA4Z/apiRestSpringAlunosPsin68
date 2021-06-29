package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleUsuariosAssembler;
import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.service.RoleUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas/roleUsuarios")
public class RoleUsuariosController {

    private RoleUsuariosService roleUsuariosService;
    private RoleUsuariosAssembler roleUsuariosAssembler;

    @GetMapping()
    public List<RoleUsuariosDTO> listar(){
        return roleUsuariosService.listar();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RoleUsuariosDTO cadastrar(@Valid @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO){
        RoleUsuarios newRole = roleUsuariosAssembler.toEntity(roleUsuariosInputDTO);
        RoleUsuarios role = roleUsuariosService.cadastrar(newRole);

        return roleUsuariosAssembler.toModel(role);
    }
    @DeleteMapping("/{roleId}")
    public ResponseEntity<RoleUsuariosDTO> remover(@Valid @PathVariable long roleId) {

        roleUsuariosService.excluir(roleId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{roleId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleUsuariosDTO editar(@Valid @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO, @PathVariable long roleId){
        RoleUsuarios newRole = roleUsuariosAssembler.toEntity(roleUsuariosInputDTO);
        ResponseEntity<RoleUsuarios> roleResponseEntity = roleUsuariosService.editar(roleId, newRole);

        return roleUsuariosAssembler.toModel(roleResponseEntity.getBody());
    }
}
