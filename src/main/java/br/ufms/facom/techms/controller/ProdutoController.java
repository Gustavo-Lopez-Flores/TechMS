/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.controller;

/**
 *
 * @author gustavo
 */

import br.ufms.facom.techms.model.entity.Produto;
import br.ufms.facom.techms.model.service.ProdutoService;
import java.sql.SQLException;
import java.util.List;

public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void createProduto(Produto produto) throws SQLException {
        produtoService.createProduto(produto);
    }

    public Produto getProduto(int id) throws SQLException {
        return produtoService.getProduto(id);
    }

    public List<Produto> getAllProdutos() throws SQLException {
        return produtoService.getAllProdutos();
    }

    public void updateProduto(Produto produto) throws SQLException {
        produtoService.updateProduto(produto);
    }

    public void deleteProduto(int id) throws SQLException {
        produtoService.deleteProduto(id);
    }
}