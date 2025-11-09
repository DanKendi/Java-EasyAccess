package br.com.easyaccess.easyaccess.controller.dto;

import java.time.LocalDateTime;

public class ReservaResponseDTO {

    private Long id;
    private LocalDateTime data;
    private String status;
    private Long moradorId;
    private Long areaComumId;

    public ReservaResponseDTO() {
    }

    public ReservaResponseDTO(Long id, LocalDateTime data, String status, Long moradorId, Long areaComumId) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.moradorId = moradorId;
        this.areaComumId = areaComumId;
    }

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

    public Long getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(Long moradorId) {
        this.moradorId = moradorId;
    }

    public Long getAreaComumId() {
        return areaComumId;
    }

    public void setAreaComumId(Long areaComumId) {
        this.areaComumId = areaComumId;
    }
}
