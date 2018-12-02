package br.cefetmg.implicare.model.domain;

import java.sql.Date;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author Gabriel
 */
@Entity(name="PessoaFisica")
public class PessoaFisica {

    private long CPF;
    private String Nome;
    private Date Data_Nascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(long CPF, String Nome, Date Data_Nascimento) {
        this.CPF = CPF;
        this.Nome = Nome;
        this.Data_Nascimento = Data_Nascimento;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(Date Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

}
