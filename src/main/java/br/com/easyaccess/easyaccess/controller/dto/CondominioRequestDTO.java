package br.com.easyaccess.easyaccess.controller.dto;

import jakarta.validation.constraints.NotNull;

public class CondominioRequestDTO {

    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    @NotNull
    private String numero;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
