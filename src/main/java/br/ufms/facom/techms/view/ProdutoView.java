/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.view;

/**
 *
 * @author gustavo
 */

import br.ufms.facom.techms.controller.ProdutoController;
import br.ufms.facom.techms.model.entity.Produto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ProdutoView extends JFrame {
    private ProdutoController produtoController;
    private JTextField txtNome, txtEspecificacaoTecnica, txtGarantia, txtImagem;
    private JButton btnSalvar, btnAtualizar, btnDeletar, btnListar;

    public ProdutoView(ProdutoController produtoController) {
        this.produtoController = produtoController;
        initialize();
    }

    private void initialize() {
        setTitle("Gestão de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        JLabel lblEspecificacaoTecnica = new JLabel("Especificação Técnica:");
        txtEspecificacaoTecnica = new JTextField();
        JLabel lblGarantia = new JLabel("Garantia:");
        txtGarantia = new JTextField();
        JLabel lblImagem = new JLabel("Imagem:");
        txtImagem = new JTextField();

        btnSalvar = new JButton("Salvar");
        btnAtualizar = new JButton("Atualizar");
        btnDeletar = new JButton("Deletar");
        btnListar = new JButton("Listar");

        add(lblNome);
        add(txtNome);
        add(lblEspecificacaoTecnica);
        add(txtEspecificacaoTecnica);
        add(lblGarantia);
        add(txtGarantia);
        add(lblImagem);
        add(txtImagem);
        add(btnSalvar);
        add(btnAtualizar);
        add(btnDeletar);
        add(btnListar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produto produto = new Produto();
                    produto.setNome(txtNome.getText());
                    produto.setEspecificacaoTecnica(txtEspecificacaoTecnica.getText());
                    produto.setGarantia(txtGarantia.getText());
                    produto.setImagem(txtImagem.getText());
                    produtoController.createProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar produto.");
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de atualização
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de deleção
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Produto> produtos = produtoController.getAllProdutos();
                    StringBuilder sb = new StringBuilder();
                    for (Produto produto : produtos) {
                        sb.append(produto.getNome()).append(", ").append(produto.getEspecificacaoTecnica()).append(", ")
                                .append(produto.getGarantia()).append(", ").append(produto.getImagem()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao listar produtos.");
                }
            }
        });
    }
}