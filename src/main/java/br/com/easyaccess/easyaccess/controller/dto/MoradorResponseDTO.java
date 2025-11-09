package br.com.easyaccess.easyaccess.controller.dto;

import br.com.easyaccess.easyaccess.entity.Morador;

import java.util.Date;

public class MoradorResponseDTO {

    private Integer id;
    private Integer usuarioId;
    private Integer condominioId;
    private String status;
    private Date dateEntrada;

    public MoradorResponseDTO() {
    }

    public MoradorResponseDTO(Integer id, Integer usuarioId, Integer condominioId, String status, Date dateEntrada) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.condominioId = condominioId;
        this.status = status;
        this.dateEntrada = dateEntrada;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Integer condominioId) {
        this.condominioId = condominioId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateEntrada() {
        return dateEntrada;
    }

    public void setDateEntrada(Date dateEntrada) {
        this.dateEntrada = dateEntrada;
    }
}