package br.edu.ifsp.cjo.ads.web3.ExercicioFixacao1.repository;

import br.edu.ifsp.cjo.ads.web3.ExercicioFixacao1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> {}