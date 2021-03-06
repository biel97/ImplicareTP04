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
@Entity(name="CandidatoVaga")
public class CandidatoVaga implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf")
    private Long CPF;
    private String Status_Candidato;
    @Column(name = "cod_cargo")
    private int Cod_Cargo;
    @Column(name = "cnpj")
    private long CNPJ;
    @Column(name = "dat_publicacao")
    private Date Dat_Publicacao;

    public CandidatoVaga() {
    }

    public CandidatoVaga(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, String Status_Candidato) {
        this.CPF = CPF;
        this.Cod_Cargo = Cod_Cargo;
        this.CNPJ = CNPJ;
        this.Dat_Publicacao = Dat_Publicacao;
        this.Status_Candidato = Status_Candidato;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Date getDat_Publicacao() {
        return Dat_Publicacao;
    }

    public void setDat_Publicacao(Date Dat_Publicacao) {
        this.Dat_Publicacao = Dat_Publicacao;
    }

    public String getStatus_Candidato() {
        return Status_Candidato;
    }

    public void setStatus_Candidato(String Status_Candidato) {
        this.Status_Candidato = Status_Candidato;
    }

}
