package Guincho;

public class GuinchoPesadoComPlatHidraulicaMunck extends Guincho {
    public GuinchoPesadoComPlatHidraulicaMunck() {
        super("Guincho Pesado com Plataforma Hidráulica Munck");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 100;
    }

    @Override
    public boolean podeLevantarTombado() {
        return false;
    }

    @Override
    public double getCapacidadePeso() {
        return 150;
    }
}