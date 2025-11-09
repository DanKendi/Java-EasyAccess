package br.com.easyaccess.easyaccess.controller.dto;

import br.com.easyaccess.easyaccess.entity.Condominio;

import java.math.BigDecimal;

public class AreaComumResponseDTO {


    private Integer id;

    private String nome;

    private String descricao;

    private BigDecimal precoBase;

    private Integer condominioId;

    public AreaComumResponseDTO() {
    }

    public AreaComumResponseDTO(Integer id, String nome, String descricao, BigDecimal precoBase, Integer condominioId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.condominioId = condominioId;
    }

    public Integer getId() {
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

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public Integer getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Integer condominioId) {
        this.condominioId = condominioId;
    }
}
