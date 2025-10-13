package br.com.easyaccess.easyaccess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VAGA_VISITANTE")
public class VagaVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "identificacao_interna")
    private String identificacaoInterna;

    @ManyToOne(optional = false)
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;

    public Long getId() {
        return id;
    }

    public String getIdentificacaoInterna() {
        return identificacaoInterna;
    }

    public void setIdentificacaoInterna(String identificacaoInterna) {
        this.identificacaoInterna = identificacaoInterna;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
