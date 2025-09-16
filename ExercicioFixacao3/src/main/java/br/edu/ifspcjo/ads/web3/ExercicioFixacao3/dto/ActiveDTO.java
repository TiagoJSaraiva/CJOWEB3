package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto;

import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class ActiveDTO {
    @NotNull(message = "campo ativo é obrigatório")
    private Boolean ativo;

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
