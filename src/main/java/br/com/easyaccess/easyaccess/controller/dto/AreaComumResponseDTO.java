package br.com.easyaccess.easyaccess.controller.dto;

import br.com.easyaccess.easyaccess.entity.Condominio;

public class AreaComumResponseDTO {


    private Long id;

    private String nome;

    private String descricao;

    private Double precoBase;

    private Long condominioId;

    public AreaComumResponseDTO() {
    }

    public AreaComumResponseDTO(Long id, String nome, String descricao, Double precoBase, Long condominioId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.condominioId = condominioId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
