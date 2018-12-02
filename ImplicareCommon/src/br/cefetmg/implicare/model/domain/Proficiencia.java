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
@Entity(name="Proficiencia")
public class Proficiencia {

    private int Cod_Proficiencia;
    private String Nivel_Proficiencia;

    public Proficiencia() {
    }

    public Proficiencia(int Cod_Proficiencia, String Nivel_Proficiencia) {
        this.Cod_Proficiencia = Cod_Proficiencia;
        this.Nivel_Proficiencia = Nivel_Proficiencia;
    }

    public int getCod_Proficiencia() {
        return Cod_Proficiencia;
    }

    public void setCod_Proficiencia(int Cod_Proficiencia) {
        this.Cod_Proficiencia = Cod_Proficiencia;
    }

    public String getNivel_Proficiencia() {
        return Nivel_Proficiencia;
    }

    public void setNivel_Proficiencia(String Nivel_Proficiencia) {
        this.Nivel_Proficiencia = Nivel_Proficiencia;
    }

}
