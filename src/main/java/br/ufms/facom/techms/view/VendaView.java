/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.view;

/**
 *
 * @author gustavo.flores
 */
import br.ufms.facom.techms.controller.VendaController;
import br.ufms.facom.techms.model.entity.Cliente;
import br.ufms.facom.techms.model.entity.Produto;
import br.ufms.facom.techms.model.entity.ItemVenda;
import br.ufms.facom.techms.model.entity.Venda;
import br.ufms.facom.techms.model.entity.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class VendaView extends JFrame {
    private VendaController vendaController;
    private JComboBox<Produto> cmbProdutos;
    private JComboBox<Funcionario> cmbFuncionarios;
    private JComboBox<Cliente> cmbClientes; 
    private JSpinner spnQuantidade;
    private JButton btnAdicionarItem, btnRemoverItem, btnFinalizarVenda;
    private JTextArea txtItensVenda;
    private DefaultComboBoxModel<Produto> produtoModel;
    private DefaultComboBoxModel<Funcionario> funcionarioModel;
    private DefaultComboBoxModel<Cliente> clienteModel; 
    private Venda venda;

    public VendaView(VendaController vendaController) {
        this.vendaController = vendaController;
        this.venda = new Venda();
        initialize();
    }

   private void initialize() {
        setTitle("Realizar Venda");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));  // Atualize para 9 linhas

        JLabel lblFuncionario = new JLabel("Funcionário:");
        cmbFuncionarios = new JComboBox<>();
        funcionarioModel = new DefaultComboBoxModel<>();
        carregarFuncionarios();
        cmbFuncionarios.setModel(funcionarioModel);

        JLabel lblCliente = new JLabel("Cliente:");
        cmbClientes = new JComboBox<>();
        clienteModel = new DefaultComboBoxModel<>();
        carregarClientes();
        cmbClientes.setModel(clienteModel);

        JLabel lblProduto = new JLabel("Produto:");
        cmbProdutos = new JComboBox<>();
        produtoModel = new DefaultComboBoxModel<>();
        carregarProdutos();
        cmbProdutos.setModel(produtoModel);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        spnQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        JLabel lblFormaPagamento = new JLabel("Forma de Pagamento:");
        cmbFormaPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito"});

        btnAdicionarItem = new JButton("Adicionar Item");
        btnRemoverItem = new JButton("Remover Item");
        btnFinalizarVenda = new JButton("Finalizar Venda");

        txtItensVenda = new JTextArea();
        txtItensVenda.setEditable(false);

        add(lblFuncionario);
        add(cmbFuncionarios);
        add(lblCliente);
        add(cmbClientes);
        add(lblProduto);
        add(cmbProdutos);
        add(lblQuantidade);
        add(spnQuantidade);
        add(lblFormaPagamento);
        add(cmbFormaPagamento);
        add(btnAdicionarItem);
        add(btnRemoverItem);
        add(new JScrollPane(txtItensVenda));
        add(btnFinalizarVenda);

        btnAdicionarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produto = (Produto) cmbProdutos.getSelectedItem();
                int quantidade = (Integer) spnQuantidade.getValue();
                adicionarItem(produto, quantidade);
            }
        });

        btnRemoverItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica para remover item
            }
        });

        btnFinalizarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarVenda();
            }
        });
    }

    private void carregarProdutos() {
        try {
            List<Produto> produtos = vendaController.getAllProdutos();
            for (Produto produto : produtos) {
                produtoModel.addElement(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos.");
        }
    }

    private void carregarFuncionarios() {
        try {
            List<Funcionario> funcionarios = vendaController.getAllFuncionarios();
            for (Funcionario funcionario : funcionarios) {
                funcionarioModel.addElement(funcionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar funcionários.");
        }
    }

    private void carregarClientes() {
        try {
            List<Cliente> clientes = vendaController.getAllClientes();
            for (Cliente cliente : clientes) {
                clienteModel.addElement(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar clientes.");
        }
    }


    private void adicionarItem(Produto produto, int quantidade) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produto);
        itemVenda.setQuantidade(quantidade);
        itemVenda.setPrecoUnitario(produto.getPrecoVenda());
        venda.addItem(itemVenda);
        atualizarTextoItensVenda();
    }

    private void removerItem(Produto produto) {
        ItemVenda itemRemover = null;
        for (ItemVenda item : venda.getItens()) {
            if (item.getProduto().getId() == produto.getId()) {
                itemRemover = item;
                break;
            }
        }
        if (itemRemover != null) {
            venda.removeItem(itemRemover);
            atualizarTextoItensVenda();
        }
    }

    private void atualizarTextoItensVenda() {
        StringBuilder sb = new StringBuilder();
        for (ItemVenda item : venda.getItens()) {
            sb.append(item.getProduto().getNome())
              .append(" - Quantidade: ")
              .append(item.getQuantidade())
              .append(" - Preço: ")
              .append(item.getPrecoUnitario())
              .append("\n");
        }
        txtItensVenda.setText(sb.toString());
    }

   private void finalizarVenda() {
        Funcionario funcionario = (Funcionario) cmbFuncionarios.getSelectedItem();
        if (funcionario == null) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário.");
            return;
        }
        venda.setFuncionario(funcionario);

        Cliente cliente = (Cliente) cmbClientes.getSelectedItem();  // Obtém o cliente selecionado
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente.");
            return;
        }
        venda.setCliente(cliente);  // Define o cliente na venda

        try {
            vendaController.finalizarVenda(venda);
            JOptionPane.showMessageDialog(this, "Venda finalizada com sucesso!");
            venda = new Venda();  // Resetar a venda atual
            atualizarTextoItensVenda();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar venda: " + e.getMessage());
            e.printStackTrace();
        }
    }

}