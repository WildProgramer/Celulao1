/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Norb7492
 */
public class Aparelho {
    private long idAparelho;
    private String marca;
    private long serie;
    private String observacao;

    public long getIdAparelho() {
        return idAparelho;
    }

    public void setIdAparelho(long idAparelho) {
        this.idAparelho = idAparelho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getSerie() {
        return serie;
    }

    public void setSerie(long serie) {
        this.serie = serie;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
