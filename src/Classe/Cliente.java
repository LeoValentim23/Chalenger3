package Classe;

public class Cliente {
    private String nome;
    private String carro;
    private String placa;
    private String pesoVeiculo;
    private String cpf;

    public Cliente(String nome, String carro, String placa, String pesoVeiculo, String cpf) {
        this.nome = nome;
        this.carro = carro;
        this.placa = placa;
        this.pesoVeiculo = pesoVeiculo;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCarro() {
        return carro;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPesoVeiculo() {
        return pesoVeiculo;
    }

    public String getCpf() {
        return cpf;
    }
}
