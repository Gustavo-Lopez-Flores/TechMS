/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.view;

import br.ufms.facom.techms.controller.ProdutoController;
import br.ufms.facom.techms.model.entity.Produto;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavo.flores
 */
public class ProdutoView extends javax.swing.JFrame {
    private ProdutoController produtoController;

    /**
     * Creates new form ProdutoView
     */
    public ProdutoView(ProdutoController produtoController) {
        this.produtoController = produtoController;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEspecificacaoTecnica = new javax.swing.JLabel();
        txtEspecificacaoTecnica = new javax.swing.JTextField();
        lblGarantia = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        txtImagem = new javax.swing.JTextField();
        lblAnoFabricacao = new javax.swing.JLabel();
        txtAnoFabricacao = new javax.swing.JTextField();
        lblPrecoVenda = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblCategoriaId = new javax.swing.JLabel();
        txtCategoriaId = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome:");

        lblEspecificacaoTecnica.setText("Especificação Técnica:");

        lblGarantia.setText("Garantia:");

        lblImagem.setText("Imagem:");

        lblAnoFabricacao.setText("Ano de Fabricação:");

        lblPrecoVenda.setText("Preço de Venda:");

        lblQuantidade.setText("Quantidade:");

        lblCategoriaId.setText("ID da Categoria:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblEspecificacaoTecnica)
                    .addComponent(lblGarantia)
                    .addComponent(lblImagem)
                    .addComponent(lblAnoFabricacao)
                    .addComponent(lblPrecoVenda)
                    .addComponent(lblQuantidade)
                    .addComponent(lblCategoriaId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtEspecificacaoTecnica)
                    .addComponent(txtGarantia)
                    .addComponent(txtImagem)
                    .addComponent(txtAnoFabricacao)
                    .addComponent(txtPrecoVenda)
                    .addComponent(txtQuantidade)
                    .addComponent(txtCategoriaId))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecificacaoTecnica)
                    .addComponent(txtEspecificacaoTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGarantia)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagem)
                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnoFabricacao)
                    .addComponent(txtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoVenda)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoriaId)
                    .addComponent(txtCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnDeletar)
                    .addComponent(btnListar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            Produto produto = new Produto();
            produto.setNome(txtNome.getText());
            produto.setEspecificacaoTecnica(txtEspecificacaoTecnica.getText());
            produto.setGarantia(txtGarantia.getText());
            produto.setImagem(txtImagem.getText());
            produto.setAnoFabricacao(Integer.parseInt(txtAnoFabricacao.getText()));
            produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            produto.setCategoriaId(Integer.parseInt(txtCategoriaId.getText()));
            produtoController.createProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto.");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Formato de número inválido.");
        }
    }                                         

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Lógica de atualização
    }                                            

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Lógica de deleção
    }                                          

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            List<Produto> produtos = produtoController.getAllProdutos();
            StringBuilder sb = new StringBuilder();
            for (Produto produto : produtos) {
                sb.append(produto.getNome()).append(", ")
                  .append(produto.getEspecificacaoTecnica()).append(", ")
                  .append(produto.getGarantia()).append(", ")
                  .append(produto.getImagem()).append(", ")
                  .append(produto.getAnoFabricacao()).append(", ")
                  .append(produto.getPrecoVenda()).append(", ")
                  .append(produto.getQuantidade()).append(", ")
                  .append(produto.getCategoriaId()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar produtos.");
        }
    }                                         

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblEspecificacaoTecnica;
    private javax.swing.JLabel lblGarantia;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblAnoFabricacao;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblCategoriaId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtEspecificacaoTecnica;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtImagem;
    private javax.swing.JTextField txtAnoFabricacao;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtCategoriaId;
    // End of variables declaration                   
}