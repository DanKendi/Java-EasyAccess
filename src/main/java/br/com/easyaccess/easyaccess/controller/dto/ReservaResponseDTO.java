package br.com.easyaccess.easyaccess.controller.dto;

import java.util.Date;

public class ReservaResponseDTO {

    private Integer id;
    private Date data;
    private String status;
    private Integer moradorId;
    private Integer areaComumId;

    public ReservaResponseDTO() {
    }

    public ReservaResponseDTO(Integer id, Date data, String status, Integer moradorId, Integer areaComumId) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.moradorId = moradorId;
        this.areaComumId = areaComumId;
    }

    public Integer getId() {
        return id;
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
