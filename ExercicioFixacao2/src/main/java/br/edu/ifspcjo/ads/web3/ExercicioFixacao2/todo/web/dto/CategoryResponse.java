package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web.dto;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.category.Category;

public record CategoryResponse(Long id, String nome) {
	public static CategoryResponse of(Category c) {
		return new CategoryResponse(c.getId(), c.getNome());
	}
}