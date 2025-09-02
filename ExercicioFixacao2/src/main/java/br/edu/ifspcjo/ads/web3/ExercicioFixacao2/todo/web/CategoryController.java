package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.category.Category;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.repo.CategoryRepository;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web.dto.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CategoryRepository repo;

	public CategoryController(CategoryRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	public ResponseEntity<CategoryResponse> create(@Valid @RequestBody Category body, UriComponentsBuilder uriBuilder) {
		Category saved = repo.save(body);
		var uri = uriBuilder.path("/api/categories/{id}").build(saved.getId());
		return ResponseEntity.created(uri).body(CategoryResponse.of(saved));
	}
}
