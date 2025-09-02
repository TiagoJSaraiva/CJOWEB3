package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.domain.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "categories", uniqueConstraints = {
		@UniqueConstraint(name = "uk_categories_nome", columnNames = "nome") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "nome é obrigatório")
	@Size(max = 60, message = "nome excede o limite de 60 caracteres")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
}