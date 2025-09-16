package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto;

import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class CategoryDTO {
    private Long codigo;

    @NotBlank(message = "nome da categoria é obrigatório")
    private String nome;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
