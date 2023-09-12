package Menus;

import Guincho.*;

import java.util.Scanner;

public class MenuChamado {
    public static void realizarChamado(Scanner scanner) {
        System.out.println("Chamado");

        System.out.println("Informe o peso do veículo:");
        int pesoVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("O veículo está tombado? (S/N):");
        String respostaTombado = scanner.nextLine();

        boolean veiculoTombado = respostaTombado.equalsIgnoreCase("S");

        Guincho[] guinchos = {
                new GuinchoPesadoComPlatHidraulicaMunck(),
                new GuinchoPesadoComPlataformaHidraulicaEBand(),
                new GuinchoPesadoComQuintaRodaELanca(),
                new GuinchoPesadoComQuintaRodaPesadoComTorreELanca(),
                new GuinchoPesadoNãoPadrao(),
                new GuinchoTecnicoPesadoParaQuinchoPesado()
        };

        int guinchoSelecionado = -1;
        double diferencaPesoMaisProximo = Double.MAX_VALUE;

        for (int i = 0; i < guinchos.length; i++) {
            if (guinchos[i].pesoAdequado(pesoVeiculo) && (!veiculoTombado || guinchos[i].podeLevantarTombado())) {
                double capacidadePesoGuincho = guinchos[i].getCapacidadePeso();
                double diferencaPeso = Math.abs(capacidadePesoGuincho - pesoVeiculo);
                if (diferencaPeso < diferencaPesoMaisProximo) {
                    diferencaPesoMaisProximo = diferencaPeso;
                    guinchoSelecionado = i;
                }
            }
        }

        if (guinchoSelecionado != -1) {
            Guincho guincho = guinchos[guinchoSelecionado];
            System.out.println("Guincho selecionado: " + guincho.getNome());
        } else {
            System.out.println("Nenhum guincho disponível para o veículo informado.");
        }
    }
}