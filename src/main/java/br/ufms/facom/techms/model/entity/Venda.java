/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.entity;

/**
 *
 * @author gustavo
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda implements Serializable {
    private int id;
    private Date data;
    private String formaPagamento;
    private double valorTotal;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<ItemVenda> itens;

    // Construtor
    public Venda() {
        this.itens = new ArrayList<>();
        this.data = new Date();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
        calcularValorTotal();
    }

    // Método para adicionar um item à venda e recalcular o valor total
    public void addItem(ItemVenda item) {
        this.itens.add(item);
        calcularValorTotal();
    }

    // Método para remover um item da venda e recalcular o valor total
    public void removeItem(ItemVenda item) {
        this.itens.remove(item);
        calcularValorTotal();
    }

    // Método para calcular o valor total da venda
    private void calcularValorTotal() {
        this.valorTotal = 0;
        for (ItemVenda item : itens) {
            this.valorTotal += item.getQuantidade() * item.getPrecoUnitario();
        }
    }
}