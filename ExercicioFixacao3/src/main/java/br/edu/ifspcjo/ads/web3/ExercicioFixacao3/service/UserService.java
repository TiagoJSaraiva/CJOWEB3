package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.service;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto.UserDTO;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity.User;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository usuarioRepository) {
        this.userRepository = usuarioRepository;
    }

    @Transactional
    public User updateUsuario(Long codigo, UserDTO dto) {
    	User usuario = userRepository.findById(codigo)
            .orElseThrow(() -> new IllegalArgumentException("Usuário com código " + codigo + " não existe"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha()); // Em produção: hash da senha!
        usuario.setTelefone(dto.getTelefone());

        return userRepository.save(usuario);
    }

    @Transactional
    public User setAtivo(Long codigo, Boolean ativo) {
    	User usuario = userRepository.findById(codigo)
            .orElseThrow(() -> new IllegalArgumentException("Usuário com código " + codigo + " não existe"));
        usuario.setAtivo(ativo);
        return userRepository.save(usuario);
    }
}
