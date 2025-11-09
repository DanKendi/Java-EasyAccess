package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

public class AreaComumRequestDTO {

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private Double precoBase;

    @NotNull
    private Long condominioId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome= nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public Long getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Long condominioId) {
        this.condominioId = condominioId;
    }
}
