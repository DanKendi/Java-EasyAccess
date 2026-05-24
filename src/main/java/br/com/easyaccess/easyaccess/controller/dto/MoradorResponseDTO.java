package br.com.easyaccess.easyaccess.controller.dto;

import java.util.Date;

public class MoradorResponseDTO {

    private Integer id;
    private String status;
    private Date dateEntrada;

    // IDs (mantidos para compatibilidade)
    private Integer usuarioId;
    private Integer condominioId;

    // Dados expandidos do usuário
    private String nome;
    private String email;

    // Dados expandidos do condomínio
    private String condominioNome;
    private String condominioEndereco;

    public MoradorResponseDTO() {}

    public MoradorResponseDTO(Integer id, String status, Date dateEntrada,
                               Integer usuarioId, Integer condominioId,
                               String nome, String email,
                               String condominioNome, String condominioEndereco) {
        this.id = id;
        this.status = status;
        this.dateEntrada = dateEntrada;
        this.usuarioId = usuarioId;
        this.condominioId = condominioId;
        this.nome = nome;
        this.email = email;
        this.condominioNome = condominioNome;
        this.condominioEndereco = condominioEndereco;
    }

    public Integer getId() { return id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDateEntrada() { return dateEntrada; }
    public void setDateEntrada(Date dateEntrada) { this.dateEntrada = dateEntrada; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public Integer getCondominioId() { return condominioId; }
    public void setCondominioId(Integer condominioId) { this.condominioId = condominioId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCondominioNome() { return condominioNome; }
    public void setCondominioNome(String condominioNome) { this.condominioNome = condominioNome; }

    public String getCondominioEndereco() { return condominioEndereco; }
    public void setCondominioEndereco(String condominioEndereco) { this.condominioEndereco = condominioEndereco; }
}
