/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.service;

/**
 *
 * @author gustavo
 */


import br.ufms.facom.techms.model.dao.ProdutoDAO;
import br.ufms.facom.techms.model.entity.Produto;
import java.sql.SQLException;
import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void createProduto(Produto produto) throws SQLException {
        produtoDAO.create(produto);
    }

    public Produto getProduto(int id) throws SQLException {
        return produtoDAO.read(id);
    }

    public List<Produto> getAllProdutos() throws SQLException {
        return produtoDAO.readAll();
    }

    public void updateProduto(Produto produto) throws SQLException {
        produtoDAO.update(produto);
    }

    public void deleteProduto(int id) throws SQLException {
        produtoDAO.delete(id);
    }
}