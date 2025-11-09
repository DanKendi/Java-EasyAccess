package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MoradorRequestDTO {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long condominioId;

    @NotNull
    private String status;

    @NotNull
    private LocalDateTime dataEntrada;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioSistemaId) {
        this.usuarioId = usuarioId;
    }

    public Long getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Long condominioId) {
        this.condominioId = condominioId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}