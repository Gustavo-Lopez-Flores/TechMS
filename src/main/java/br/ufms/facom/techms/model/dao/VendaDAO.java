/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.dao;

/**
 *
 * @author gustavo.flores
 */
import br.ufms.facom.techms.model.entity.ItemVenda;
import br.ufms.facom.techms.model.entity.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class VendaDAO {
    private Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }

   public void create(Venda venda) throws SQLException {
    String sqlVenda = "INSERT INTO venda (data, formaPagamento, valorTotal, funcionarioId, clienteId) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmtVenda = connection.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)) {
        stmtVenda.setDate(1, new java.sql.Date(venda.getData().getTime()));
        stmtVenda.setString(2, venda.getFormaPagamento());  // Certifique-se de que formaPagamento não é nulo aqui
        stmtVenda.setDouble(3, venda.getValorTotal());
        stmtVenda.setInt(4, venda.getFuncionario().getId());
        stmtVenda.setInt(5, venda.getCliente().getId());
        stmtVenda.executeUpdate();

        try (var generatedKeys = stmtVenda.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                venda.setId(generatedKeys.getInt(1));
            }
        }

        for (ItemVenda item : venda.getItens()) {
            String sqlItemVenda = "INSERT INTO itemVenda (vendaId, produtoId, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtItemVenda = connection.prepareStatement(sqlItemVenda)) {
                stmtItemVenda.setInt(1, venda.getId());
                stmtItemVenda.setInt(2, item.getProduto().getId());
                stmtItemVenda.setInt(3, item.getQuantidade());
                stmtItemVenda.setDouble(4, item.getPrecoUnitario());
                stmtItemVenda.executeUpdate();
            }
        }
    }
}

}