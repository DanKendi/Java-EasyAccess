package br.com.easyaccess.easyaccess.dto;

import br.com.easyaccess.easyaccess.entity.Morador;

public class MoradorResponseDTO {

    private Long id;
    private Long usuarioSistemaId;
    private Long condominioId;



    public MoradorResponseDTO() {
    }

    public static MoradorResponseDTO fromEntity(Morador morador) {
        MoradorResponseDTO dto = new MoradorResponseDTO();
        dto.setId(morador.getId());
        dto.setUsuarioSistemaId(morador.getUsuarioSistema().getId());
        dto.setCondominioId(morador.getCondominio().getId());
        return dto;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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