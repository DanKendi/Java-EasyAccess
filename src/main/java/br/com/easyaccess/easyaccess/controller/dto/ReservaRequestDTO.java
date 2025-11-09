package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaRequestDTO {

    @NotNull
    private LocalDateTime data;

    @NotNull
    private String status;

    @NotNull
    private Long moradorId;

    @NotNull
    private Long areaComumId;

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
