package br.com.easyaccess.easyaccess.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "T_EA_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, name = "senha_hash")
    private String senhaHash;

    @Column(nullable = false)
    private String perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
