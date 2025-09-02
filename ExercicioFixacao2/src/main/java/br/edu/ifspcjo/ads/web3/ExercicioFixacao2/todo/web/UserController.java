package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.user.User;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.repo.UserRepository;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserRepository repo;

	public UserController(UserRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	public ResponseEntity<UserResponse> create(@Valid @RequestBody User body, UriComponentsBuilder uriBuilder) {
		User saved = repo.save(body);
		var uri = uriBuilder.path("/api/users/{id}").build(saved.getId());
		return ResponseEntity.created(uri).body(UserResponse.of(saved));
	}
}