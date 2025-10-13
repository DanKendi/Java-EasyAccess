package br.com.easyaccess.easyaccess.dto;

import jakarta.validation.constraints.NotNull;

public class MoradorRequestDTO {

    @NotNull(message = "O ID do Usuário Sistema é obrigatório.")
    private Long usuarioSistemaId;

    @NotNull(message = "O ID do Condomínio é obrigatório.")
    private Long condominioId;
    
    public MoradorRequestDTO() {
    }


    public Long getUsuarioSistemaId() {
        return usuarioSistemaId;
    }

    public void setUsuarioSistemaId(Long usuarioSistemaId) {
        this.usuarioSistemaId = usuarioSistemaId;
    }

    public Long getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Long condominioId) {
        this.condominioId = condominioId;
    }
}