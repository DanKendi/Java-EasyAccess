package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class MoradorRequestDTO {

    @NotNull
    private Integer usuarioId;

    @NotNull
    private Integer condominioId;

    @NotNull
    private String status;

    @NotNull
    private Date dataEntrada;

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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}