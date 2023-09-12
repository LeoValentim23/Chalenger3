package Testes;


import Classe.Cliente;
import Conexao.ConnectionManager;
import Menus.MenuCadastro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MenuCadastroTest {

    private ConnectionManager connectionManager;

    @BeforeEach
    public void setUp() {
        connectionManager = new ConnectionManager();
    }

    @AfterEach
    public void tearDown() {

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clientes")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRealizarCadastro() {
        Scanner scanner = new Scanner(System.in);
        ConnectionManager connectionManager = new ConnectionManager();


        Cliente cliente = new Cliente("TesteNome", "TesteCarro", "TestePlaca", "TestePeso", "TesteCPF");




        MenuCadastro.realizarCadastro(scanner, connectionManager);



        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clientes WHERE nome = ?")) {
            preparedStatement.setString(1, cliente.getNome());
            ResultSet resultSet = preparedStatement.executeQuery();

            assertTrue(resultSet.next());


            assertEquals(cliente.getCarro(), resultSet.getString("carro"));
            assertEquals(cliente.getPlaca(), resultSet.getString("placa"));
            assertEquals(cliente.getPesoVeiculo(), resultSet.getString("peso_veiculo"));
            assertEquals(cliente.getCpf(), resultSet.getString("cpf"));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exceção SQL: " + e.getMessage());
        }
    }
}
