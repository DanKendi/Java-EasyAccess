package br.com.easyaccess.easyaccess.controller.dto;

import br.com.easyaccess.easyaccess.entity.enuns.Role;

public class UsuarioResponseDTO {

    private Integer id;

    private String nome;

    private String email;

    private String senhaHash;

    private Role perfil;


    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Integer id, String nome, String email, String senhaHash, Role perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Role getPerfil() {
        return perfil;
    }

    public void setPerfil(Role perfil) {
        this.perfil = perfil;
    }

}
