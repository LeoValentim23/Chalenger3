package Guincho;

public class GuinchoPesadoComPlataformaHidraulicaEBand extends Guincho  {
    public GuinchoPesadoComPlataformaHidraulicaEBand() {
        super("Guincho Pesado com Plataforma Hidráulica e Bandeira");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 100;
    }

    @Override
    public boolean podeLevantarTombado() {
        return true;
    }

    @Override
    public double getCapacidadePeso() {
        return 150;
    }
}