
package model;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class Pessoa {
    
    
    private long idPessoa;
    private String nome;
    private long cpf;
    private long cnpj;
    private String endereco;

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    
    
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

  
    
    

    
    
        
    
    
}
