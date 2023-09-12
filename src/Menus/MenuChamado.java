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

        System.out.println("Seu veículo contém modificações?");
        System.out.println("1. Número de eixos");
        System.out.println("2. Carga");
        System.out.println("3. Tipo de carga");

        int tipoModificacao = scanner.nextInt();
        scanner.nextLine();

        // Lógica para lidar com as modificações no veículo, se necessário.
        switch (tipoModificacao) {
            case 1:
                // Lógica para número de eixos
                break;
            case 2:
                // Lógica para carga
                break;
            case 3:
                // Lógica para tipo de carga
                break;
            default:
                System.out.println("Opção de modificação inválida.");
                break;
        }

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
