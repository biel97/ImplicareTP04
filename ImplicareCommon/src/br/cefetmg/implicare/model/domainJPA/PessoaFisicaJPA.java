package br.cefetmg.implicare.model.domainJPA;

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
@Entity(name="PessoaFisicaJPA")
public class PessoaFisicaJPA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf")
    private Long CPF;
    private String Nome;
    @Column(name = "data_nascimento")
    private Date Data_Nascimento;


    public PessoaFisicaJPA() {
    }

    public PessoaFisicaJPA(long CPF, String Nome, Date Data_Nascimento) {
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
