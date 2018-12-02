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
@Entity(name="Competencia")
public class Competencia {

    private int Cod_Competencia;
    private String Nom_Competencia;

    public Competencia() {
    }

    public Competencia(int Cod_Competencia, String Nom_Competencia) {
        this.Cod_Competencia = Cod_Competencia;
        this.Nom_Competencia = Nom_Competencia;
    }

    public int getCod_Competencia() {
        return Cod_Competencia;
    }

    public void setCod_Competencia(int Cod_Competencia) {
        this.Cod_Competencia = Cod_Competencia;
    }

    public String getNom_Competencia() {
        return Nom_Competencia;
    }

    public void setNom_Competencia(String Nom_Competencia) {
        this.Nom_Competencia = Nom_Competencia;
    }

}
