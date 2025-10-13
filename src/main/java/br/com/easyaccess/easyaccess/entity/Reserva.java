package br.com.easyaccess.easyaccess.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "valor_total")
    private double valorTotal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @ManyToOne(optional = true)
    @JoinColumn(name = "area_comum_id")
    private AreaComum areaComum;

    @ManyToOne(optional = true)
    @JoinColumn(name = "vaga_visitante_id")
    private VagaVisitante vagaVisitante;

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public AreaComum getAreaComum() {
        return areaComum;
    }

    public void setAreaComum(AreaComum areaComum) {
        this.areaComum = areaComum;
    }

    public VagaVisitante getVagaVisitante() {
        return vagaVisitante;
    }

    public void setVagaVisitante(VagaVisitante vagaVisitante) {
        this.vagaVisitante = vagaVisitante;
    }
}
