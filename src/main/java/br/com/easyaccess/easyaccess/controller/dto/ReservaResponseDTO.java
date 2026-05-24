package br.com.easyaccess.easyaccess.controller.dto;

import java.util.Date;

public class ReservaResponseDTO {

    private Integer id;
    private Date data;
    private String status;

    private Integer moradorId;
    private Integer areaComumId;

    private String moradorNome;
    private String moradorEmail;

    private String areaNome;
    private String condominioNome;

    public ReservaResponseDTO() {}

    public ReservaResponseDTO(Integer id, Date data, String status,
                               Integer moradorId, Integer areaComumId,
                               String moradorNome, String moradorEmail,
                               String areaNome, String condominioNome) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.moradorId = moradorId;
        this.areaComumId = areaComumId;
        this.moradorNome = moradorNome;
        this.moradorEmail = moradorEmail;
        this.areaNome = areaNome;
        this.condominioNome = condominioNome;
    }

    public Integer getId() { return id; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getMoradorId() { return moradorId; }
    public void setMoradorId(Integer moradorId) { this.moradorId = moradorId; }

    public Integer getAreaComumId() { return areaComumId; }
    public void setAreaComumId(Integer areaComumId) { this.areaComumId = areaComumId; }

    public String getMoradorNome() { return moradorNome; }
    public void setMoradorNome(String moradorNome) { this.moradorNome = moradorNome; }

    public String getMoradorEmail() { return moradorEmail; }
    public void setMoradorEmail(String moradorEmail) { this.moradorEmail = moradorEmail; }

    public String getAreaNome() { return areaNome; }
    public void setAreaNome(String areaNome) { this.areaNome = areaNome; }

    public String getCondominioNome() { return condominioNome; }
    public void setCondominioNome(String condominioNome) { this.condominioNome = condominioNome; }
}
