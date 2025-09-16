package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, unique = true)
    private String nome;

    // getters e setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category that = (Category) o;
        return Objects.equals(codigo, that.codigo);
    }
    @Override
    public int hashCode() { return Objects.hash(codigo); }
}
