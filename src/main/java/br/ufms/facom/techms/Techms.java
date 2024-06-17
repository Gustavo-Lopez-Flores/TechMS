/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufms.facom.techms;

import br.ufms.facom.techms.controller.ProdutoController;
import br.ufms.facom.techms.model.dao.ProdutoDAO;
import br.ufms.facom.techms.model.service.ProdutoService;
import br.ufms.facom.techms.view.ProdutoView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class Techms {

    public static void main(String[] args) throws SQLException {
        // Inicialização do banco de dados e injeção de dependências
        Connection connection = null; // Obtenha uma conexão com o banco de dados
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techms", "postgres", "postgres");
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        ProdutoService produtoService = new ProdutoService(produtoDAO);
        ProdutoController produtoController = new ProdutoController(produtoService);

        ProdutoView produtoView = new ProdutoView(produtoController);
        produtoView.setVisible(true);
    }
}