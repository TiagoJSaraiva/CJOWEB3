package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.repo;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
