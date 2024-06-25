/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.controller;

/**
 *
 * @author gustavo.flores
 */
import br.ufms.facom.techms.model.dao.ClienteDAO;
import br.ufms.facom.techms.model.dao.ProdutoDAO;
import br.ufms.facom.techms.model.dao.VendaDAO;
import br.ufms.facom.techms.model.dao.FuncionarioDAO;
import br.ufms.facom.techms.model.entity.Produto;
import br.ufms.facom.techms.model.entity.Funcionario;
import br.ufms.facom.techms.model.entity.Venda;

import java.sql.SQLException;
import java.util.List;

public class VendaController {
    private VendaDAO vendaDAO;
    private ProdutoDAO produtoDAO;
    private FuncionarioDAO funcionarioDAO;
    private ClienteDAO clienteDAO;

    public VendaController(VendaDAO vendaDAO, ProdutoDAO produtoDAO, FuncionarioDAO funcionarioDAO, ClienteDAO clienteDAO) {
        this.vendaDAO = vendaDAO;
        this.produtoDAO = produtoDAO;
        this.funcionarioDAO = funcionarioDAO;
        this.clienteDAO = clienteDAO;
    }

    public List<Produto> getAllProdutos() throws SQLException {
        return produtoDAO.readAll();
    }

    public List<Funcionario> getAllFuncionarios() throws SQLException {
        return funcionarioDAO.readAll();
    }

    public List<Cliente> getAllClientes() throws SQLException {
        return clienteDAO.readAll();
    }

    public void finalizarVenda(Venda venda) throws SQLException {
        vendaDAO.create(venda);
    }
}