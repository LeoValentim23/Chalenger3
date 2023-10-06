package Menus;

import Classe.Cliente;
import Conexao.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class MenuCadastro {
    public static void realizarCadastro(Scanner scanner, ConnectionManager connectionManager) {
        System.out.println("Cadastro Cliente");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o carro: ");
        String carro = scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Peso do veículo: ");
        String pesoVeiculo = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, carro, placa, pesoVeiculo, cpf);

        if (inserirNoBancoDeDados(novoCliente, connectionManager)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o cadastro.");
        }
    }

    public static boolean inserirNoBancoDeDados(Cliente cliente, ConnectionManager connectionManager) {
        try (Connection dbConnection = connectionManager.getConnection()) {
            String query = "INSERT INTO clientes (nome, carro, placa, peso_veiculo, cpf) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setString(2, cliente.getCarro());
                preparedStatement.setString(3, cliente.getPlaca());
                preparedStatement.setString(4, cliente.getPesoVeiculo());
                preparedStatement.setString(5, cliente.getCpf());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}