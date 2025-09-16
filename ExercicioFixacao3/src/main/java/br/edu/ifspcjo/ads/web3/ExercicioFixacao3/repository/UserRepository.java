package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.repository;


import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
