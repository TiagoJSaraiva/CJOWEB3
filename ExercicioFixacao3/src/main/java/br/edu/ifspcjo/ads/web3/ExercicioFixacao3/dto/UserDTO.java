package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class UserDTO {

    private Long codigo;

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "email inválido")
    private String email;

    @NotBlank(message = "senha é obrigatória")
    @Size(min = 6, message = "senha deve ter pelo menos 6 caracteres")
    private String senha;

    private String telefone;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

