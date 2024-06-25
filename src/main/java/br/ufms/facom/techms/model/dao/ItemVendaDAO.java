/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.dao;

import br.ufms.facom.techms.model.entity.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gustavo.flores
 */
public class ItemVendaDAO {
    private Connection connection;

    public ItemVendaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(ItemVenda itemVenda, int vendaId) throws SQLException {
        String sql = "INSERT INTO itemvenda (vendaid, produtoid, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vendaId);
            stmt.setInt(2, itemVenda.getProduto().getId());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getPrecoUnitario());
            stmt.executeUpdate();
        }
    }
}