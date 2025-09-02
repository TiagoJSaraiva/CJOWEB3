package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.repo;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}
