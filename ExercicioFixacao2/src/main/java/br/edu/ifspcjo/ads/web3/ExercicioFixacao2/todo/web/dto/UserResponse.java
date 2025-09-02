package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.web.dto;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.user.User;

public record UserResponse(Long id, String nome, String email, String telefone, boolean ativo) {
	public static UserResponse of(User u) {
		return new UserResponse(u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.isAtivo());
	}
}