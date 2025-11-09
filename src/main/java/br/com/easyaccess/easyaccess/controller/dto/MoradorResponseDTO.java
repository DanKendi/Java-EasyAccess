package br.com.easyaccess.easyaccess.controller.dto;

import br.com.easyaccess.easyaccess.entity.Morador;

import java.time.LocalDateTime;

public class MoradorResponseDTO {

    private Long id;
    private Long usuarioId;
    private Long condominioId;
    private String status;
    private LocalDateTime dateEntrada;

    public MoradorResponseDTO() {
    }

    public MoradorResponseDTO(Long id, Long usuarioId, Long condominioId, String status, LocalDateTime dateEntrada) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.condominioId = condominioId;
        this.status = status;
        this.dateEntrada = dateEntrada;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
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

    public LocalDateTime getDateEntrada() {
        return dateEntrada;
    }

    public void setDateEntrada(LocalDateTime dateEntrada) {
        this.dateEntrada = dateEntrada;
    }
}