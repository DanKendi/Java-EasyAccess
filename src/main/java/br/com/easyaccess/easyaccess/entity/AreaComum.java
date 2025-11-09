package br.com.easyaccess.easyaccess.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "T_EA_AREA_COMUM")
public class AreaComum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false, name = "preco_base")
    private Double precoBase;

    @ManyToOne(optional = false)
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;

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

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}


