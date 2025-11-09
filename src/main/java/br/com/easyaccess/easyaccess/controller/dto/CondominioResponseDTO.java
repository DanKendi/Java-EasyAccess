package br.com.easyaccess.easyaccess.controller.dto;

public class CondominioResponseDTO {

    private Integer id;

    private String nome;

    private String endereco;

    private String numero;

    public CondominioResponseDTO() {
    }

    public CondominioResponseDTO(Integer id, String nome, String endereco, String numero) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
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
