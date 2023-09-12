package Guincho;

public abstract class Guincho {

    private String nome;

    public Guincho(String nome) {
        this.nome = nome;
    }

    public abstract boolean pesoAdequado(int peso);
    public abstract boolean podeLevantarTombado();

    public String getNome() {
        return nome;
    }

    public abstract double getCapacidadePeso();
}