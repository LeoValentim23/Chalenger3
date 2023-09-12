package Guincho;

public class GuinchoPesadoComQuintaRodaPesadoComTorreELanca extends Guincho {
    public GuinchoPesadoComQuintaRodaPesadoComTorreELanca() {
        super("Guincho Pesado com Quinta Roda, Torre e Lança");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 300;
    }

    @Override
    public boolean podeLevantarTombado() {
        return true;
    }

    @Override
    public double getCapacidadePeso() {
        return 400;
    }
}