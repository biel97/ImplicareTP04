package br.cefetmg.implicare.model.domain;

import java.sql.Date;
import java.sql.Timestamp;
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
@Entity(name="CandidatoVagaDialogo")
public class CandidatoVagaDialogo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpf")
    private Long CPF;
    private String Idt_Empresa_Candidato;
    @Column(name = "cod_cargo")
    private int Cod_Cargo;
    private Timestamp Dat_Dialogo;
    private String Txt_Dialogo;
    @Column(name = "cnpj")
    private long CNPJ;
    @Column(name = "dat_publicacao")
    private Date Dat_Publicacao;

    public CandidatoVagaDialogo() {
    }

    public CandidatoVagaDialogo(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, Timestamp Dat_Dialogo, String Txt_Dialogo, String Idt_Empresa_Candidato) {
        this.CPF = CPF;
        this.Cod_Cargo = Cod_Cargo;
        this.CNPJ = CNPJ;
        this.Dat_Publicacao = Dat_Publicacao;
        this.Dat_Dialogo = Dat_Dialogo;
        this.Txt_Dialogo = Txt_Dialogo;
        this.Idt_Empresa_Candidato = Idt_Empresa_Candidato;
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

    public Timestamp getDat_Dialogo() {
        return Dat_Dialogo;
    }

    public void setDat_Dialogo(Timestamp Dat_Dialogo) {
        this.Dat_Dialogo = Dat_Dialogo;
    }

    public String getTxt_Dialogo() {
        return Txt_Dialogo;
    }

    public void setTxt_Dialogo(String Txt_Dialogo) {
        this.Txt_Dialogo = Txt_Dialogo;
    }

    public String getIdt_Empresa_Candidato() {
        return Idt_Empresa_Candidato;
    }

    public void setIdt_Empresa_Candidato(String Idt_Empresa_Candidato) {
        this.Idt_Empresa_Candidato = Idt_Empresa_Candidato;
    }

}
