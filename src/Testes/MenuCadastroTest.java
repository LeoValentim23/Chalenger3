package Testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import Classe.Cliente;
import Menus.MenuCadastro;
import Conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class MenuCadastroTest {

    private ConnectionManager connectionManager;
    private Connection dbConnection;

    @Before
    public void setUp() {
        connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();


        try {
            dbConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInserirNoBancoDeDados() {

        Cliente cliente = new Cliente("anderson", "COMPASS", "10DA-DA245", "100.00", "3432252566");


        boolean insercaoSucesso = MenuCadastro.inserirNoBancoDeDados(cliente, connectionManager);
        assertTrue("A inserção no banco de dados falhou.", insercaoSucesso);

    }

    @After
    public void tearDown() {

        try {
            dbConnection.rollback();
            dbConnection.setAutoCommit(true);
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

