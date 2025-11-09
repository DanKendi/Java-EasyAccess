package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDTO {

    @NotNull
    private String nome;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String senhaHash;

    @NotNull
    private String perfil;

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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
