package br.com.easyaccess.easyaccess.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "T_EA_AREA_COMUM")
public class AreaComum {

    @Id
    @Column(name = "id_area")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false, name = "preco_base", precision = 19, scale = 2)
    private BigDecimal precoBase;

    @ManyToOne(optional = false)
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;

    public void setId(Integer id){
        this.id = id;
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

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}


