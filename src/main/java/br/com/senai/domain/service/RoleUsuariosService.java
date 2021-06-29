package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuariosAssembler;
import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleUsuariosService {

    private RoleUsuariosRepository roleUsuariosRepository;
    private RoleUsuariosAssembler roleUsuariosAssembler;

    public List<RoleUsuariosDTO> listar() {
        return roleUsuariosAssembler.toCollectionModel(roleUsuariosRepository.findAll());
    }

    @Transactional
    public RoleUsuarios cadastrar(RoleUsuarios roleUsuarios){
        return roleUsuariosRepository.save(roleUsuarios);
    }

    @Transactional
    public ResponseEntity<Object> excluir(long roleId){

        if(!roleUsuariosRepository.existsById(roleId)){
            return ResponseEntity.notFound().build();
        }
        roleUsuariosRepository.deleteById(roleId);

        return ResponseEntity.ok(roleId);
    }
    public ResponseEntity<RoleUsuarios> editar(@Valid @PathVariable long roleId, @RequestBody RoleUsuarios roleUsuarios) {

        if(!roleUsuariosRepository.existsById(roleId)){
            return ResponseEntity.notFound().build();
        }
        roleUsuarios.setId(roleId);
        roleUsuarios = roleUsuariosRepository.save(roleUsuarios);

        return ResponseEntity.ok(roleUsuarios);
    }
}
