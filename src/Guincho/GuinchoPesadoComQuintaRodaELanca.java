package Guincho;

public class GuinchoPesadoComQuintaRodaELanca extends Guincho  {
    public GuinchoPesadoComQuintaRodaELanca() {
        super("Guincho Pesado com Quinta Roda e Lança");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 300;
    }

    @Override
    public boolean podeLevantarTombado() {
        return false;
    }

    @Override
    public double getCapacidadePeso() {
        return 400;
    }
}