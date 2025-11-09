package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ReservaRequestDTO {

    @NotNull
    private Date data;

    @NotNull
    private String status;

    @NotNull
    private Integer moradorId;

    @NotNull
    private Integer areaComumId;

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

    public Integer getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(Integer moradorId) {
        this.moradorId = moradorId;
    }

    public Integer getAreaComumId() {
        return areaComumId;
    }

    public void setAreaComumId(Integer areaComumId) {
        this.areaComumId = areaComumId;
    }
}
