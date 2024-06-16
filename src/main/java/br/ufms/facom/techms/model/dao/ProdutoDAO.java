/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.dao;

/**
 *
 * @author gustavo
 */

import br.ufms.facom.techms.model.entity.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, especificacaoTecnica, garantia, imagem) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getEspecificacaoTecnica());
            stmt.setString(3, produto.getGarantia());
            stmt.setString(4, produto.getImagem());
            stmt.executeUpdate();
        }
    }

    public Produto read(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setEspecificacaoTecnica(rs.getString("especificacaoTecnica"));
                    produto.setGarantia(rs.getString("garantia"));
                    produto.setImagem(rs.getString("imagem"));
                    return produto;
                }
            }
        }
        return null;
    }

    public List<Produto> readAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setEspecificacaoTecnica(rs.getString("especificacaoTecnica"));
                produto.setGarantia(rs.getString("garantia"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public void update(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, especificacaoTecnica = ?, garantia = ?, imagem = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getEspecificacaoTecnica());
            stmt.setString(3, produto.getGarantia());
            stmt.setString(4, produto.getImagem());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}