/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Morato
 */
public class TelefoneJPA {
    
    @Id
    @Column(name="CPF_CNPJ", nullable = false)  
    private long CPF_CNPJ;
    
    @Column(name="Num_Telefone", nullable = false)
    private String Num_Telefone;
    
    @Column(name="Tipo_Telefone", nullable = false)
    private String Tipo_Telefone;
    
    @Column(name="DDD", nullable = false)
    private int DDD;
    
    @Column(name="Ramal", nullable = false)
    private int Ramal;
    
    public TelefoneJPA(){}
    
    public TelefoneJPA(long CPF_CNPJ, String Num_Telefone, String Tipo_Telefone, int DDD, int Ramal){
        this.CPF_CNPJ = CPF_CNPJ;
        this.Num_Telefone = Num_Telefone;
        this.Tipo_Telefone = Tipo_Telefone;
        this.DDD = DDD;
        this.Ramal = Ramal;
    }

    public long getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(long CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getNum_Telefone() {
        return Num_Telefone;
    }

    public void setNum_Telefone(String Num_Telefone) {
        this.Num_Telefone = Num_Telefone;
    }

    public String getTipo_Telefone() {
        return Tipo_Telefone;
    }

    public void setTipo_Telefone(String Tipo_Telefone) {
        this.Tipo_Telefone = Tipo_Telefone;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getRamal() {
        return Ramal;
    }

    public void setRamal(int Ramal) {
        this.Ramal = Ramal;
    }
}
