package Guincho;

public class GuinchoTecnicoPesadoParaQuinchoPesado extends Guincho  {
    public GuinchoTecnicoPesadoParaQuinchoPesado() {
        super("Guincho Técnico Pesado para Guincho Pesado");
    }

    @Override
    public boolean pesoAdequado(int peso) {
        return peso > 500;
    }

    @Override
    public boolean podeLevantarTombado() {
        return true;
    }

    @Override
    public double getCapacidadePeso() {
        return 700;
    }
}