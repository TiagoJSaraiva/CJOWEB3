package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.repository;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByNome(String nome);
}

