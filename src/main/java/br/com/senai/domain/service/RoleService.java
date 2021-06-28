package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.repository.RoleRepository;
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
public class RoleService {

    private RoleRepository roleRepository;
    private RoleAssembler roleAssembler;

    public List<RoleDTO> listar() {
        return roleAssembler.toCollectionModel(roleRepository.findAll());
    }

    @Transactional
    public Role cadastrar(Role role){
        return roleRepository.save(role);
    }

    @Transactional
    public ResponseEntity<Object> excluir(String roleId){

        if(!roleRepository.existsById(roleId)){
            return ResponseEntity.notFound().build();
        }
        roleRepository.deleteById(roleId);

        return ResponseEntity.ok(roleId);
    }
    public ResponseEntity<Role> editar(@Valid @PathVariable String roleId, @RequestBody Role role) {

        if(!roleRepository.existsById(roleId)){
            return ResponseEntity.notFound().build();
        }
        roleRepository.deleteById(roleId);
        role = roleRepository.save(role);

        return ResponseEntity.ok(role);
    }
}
