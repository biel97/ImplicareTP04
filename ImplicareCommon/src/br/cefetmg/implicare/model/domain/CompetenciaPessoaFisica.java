package br.cefetmg.implicare.model.domain;

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
@Entity(name="CompetenciaPessoaFisica")
public class CompetenciaPessoaFisica {

    private long CPF;
    private int Cod_Competencia;
    private int Cod_Proficiencia;

    public CompetenciaPessoaFisica() {
    }

    public CompetenciaPessoaFisica(long CPF, int Cod_Competencia, int Cod_Proficiencia) {
        this.CPF = CPF;
        this.Cod_Competencia = Cod_Competencia;
        this.Cod_Proficiencia = Cod_Proficiencia;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getCod_Competencia() {
        return Cod_Competencia;
    }

    public void setCod_Competencia(int Cod_Competencia) {
        this.Cod_Competencia = Cod_Competencia;
    }

    public int getCod_Proficiencia() {
        return Cod_Proficiencia;
    }

    public void setCod_Proficiencia(int Cod_Proficiencia) {
        this.Cod_Proficiencia = Cod_Proficiencia;
    }

}
