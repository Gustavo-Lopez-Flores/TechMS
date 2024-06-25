/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufms.facom.techms;

import br.ufms.facom.techms.controller.ProdutoController;
import br.ufms.facom.techms.controller.VendaController;
import br.ufms.facom.techms.model.dao.ProdutoDAO;
import br.ufms.facom.techms.model.dao.VendaDAO;
import br.ufms.facom.techms.model.dao.FuncionarioDAO;
import br.ufms.facom.techms.model.service.ProdutoService;
import br.ufms.facom.techms.view.ProdutoView;
import br.ufms.facom.techms.view.VendaView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Techms {

    public static void main(String[] args) throws SQLException {
        // Inicialização do banco de dados e injeção de dependências
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techms", "postgres", "postgres");

        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        VendaDAO vendaDAO = new VendaDAO(connection);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);

        ProdutoService produtoService = new ProdutoService(produtoDAO);

        ProdutoController produtoController = new ProdutoController(produtoService);
        VendaController vendaController = new VendaController(vendaDAO, produtoDAO, funcionarioDAO);

        ProdutoView produtoView = new ProdutoView(produtoController);
        VendaView vendaView = new VendaView(vendaController);
        
        produtoView.setVisible(true);
        vendaView.setVisible(true);
    }
}