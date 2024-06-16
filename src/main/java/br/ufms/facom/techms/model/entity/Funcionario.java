/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufms.facom.techms.model.entity;

/**
 *
 * @author gustavo
 */

public class Funcionario extends Pessoa {
    private String cargo;
    private String setor;
    private double salario;
    private String numCarteiraTrabalho;

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNumCarteiraTrabalho() {
        return numCarteiraTrabalho;
    }

    public void setNumCarteiraTrabalho(String numCarteiraTrabalho) {
        this.numCarteiraTrabalho = numCarteiraTrabalho;
    }
}