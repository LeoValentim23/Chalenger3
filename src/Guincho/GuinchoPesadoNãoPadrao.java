package Guincho;

public class GuinchoPesadoNãoPadrao extends Guincho {
    public GuinchoPesadoNãoPadrao() {
        super("Guincho Pesado Não Padrão");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 500;
    }

    @Override
    public boolean podeLevantarTombado() {
        return false;
    }

    @Override
    public double getCapacidadePeso() {
        return 600;
    }
}