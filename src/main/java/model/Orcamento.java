/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class Orcamento {
    
    private long idOrcamento;
    private double valorPeca;
    private double valorServico;
    private double precoTotal;
    private int statusPagamento;
    private int autoriza;
    

    public long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public int getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(int statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public int getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(int autoriza) {
        this.autoriza = autoriza;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
    
    
}
