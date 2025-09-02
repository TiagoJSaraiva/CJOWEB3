package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(name = "uk_users_email", columnNames = "email") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "nome é obrigatório")
	@Size(max = 100, message = "nome excede o limite de 100 caracteres")
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@NotNull(message = "email é obrigatório")
	@Email(message = "email inválido")
	@Size(max = 150, message = "email excede o limite de 150 caracteres")
	@Column(name = "email", nullable = false, length = 150)
	private String email;

	@NotNull(message = "senha é obrigatória")
	@Size(max = 120, message = "senha excede o limite de 120 caracteres")
	@Column(name = "senha", nullable = false, length = 120)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // nunca retorna a senha
	private String senha;

	@Size(max = 20, message = "telefone excede o limite de 20 caracteres")
	@Column(name = "telefone", length = 20)
	private String telefone;

	@Builder.Default
	@Column(name = "ativo", nullable = false)
	private boolean ativo = true;
}