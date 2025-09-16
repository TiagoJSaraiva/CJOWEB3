package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.controller;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto.UserDTO;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto.ActiveDTO;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity.User;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // PUT para atualizar dados completos do usuário (exceto 'ativo')
    @PutMapping("/{codigo}")
    public ResponseEntity<?> updateUsuario(
            @PathVariable Long codigo,
            @Valid @RequestBody UserDTO usuarioDTO) {

        User updated = userService.updateUsuario(codigo, usuarioDTO);
        return ResponseEntity.ok(updated);
    }

    // PUT para alterar apenas o atributo 'ativo' do usuário
    @PutMapping("/{codigo}/ativo")
    public ResponseEntity<?> alterarAtivo(
            @PathVariable Long codigo,
            @Valid @RequestBody ActiveDTO ativoDTO) {

    	User updated = userService.setAtivo(codigo, ativoDTO.getAtivo());
        return ResponseEntity.ok(updated);
    }
}
