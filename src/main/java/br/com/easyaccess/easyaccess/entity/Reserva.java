package br.com.easyaccess.easyaccess.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_EA_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @ManyToOne(optional = true)
    @JoinColumn(name = "area_comum_id")
    private AreaComum areaComum;


    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
