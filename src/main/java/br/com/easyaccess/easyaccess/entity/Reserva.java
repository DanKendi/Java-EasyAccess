package br.com.easyaccess.easyaccess.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "T_EA_RESERVA")
public class Reserva {

    @Id
    @Column(name = "ID_RESERVA")
    private Integer id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @ManyToOne(optional = true)
    @JoinColumn(name = "area_comum_id")
    private AreaComum areaComum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
