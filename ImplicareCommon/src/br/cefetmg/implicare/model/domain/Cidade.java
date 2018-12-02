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
@Entity(name="Cidade")
public class Cidade {

    private int Cod_Estado;
    private int Cod_Cidade;
    private String Nom_Cidade;

    public Cidade() {
    }

    public Cidade(int Cod_Estado, int Cod_Cidade, String Nom_Cidade) {
        this.Cod_Estado = Cod_Estado;
        this.Cod_Cidade = Cod_Cidade;
        this.Nom_Cidade = Nom_Cidade;
    }

    public int getCod_Estado() {
        return Cod_Estado;
    }

    public void setCod_Estado(int Cod_Estado) {
        this.Cod_Estado = Cod_Estado;
    }

    public int getCod_Cidade() {
        return Cod_Cidade;
    }

    public void setCod_Cidade(int Cod_Cidade) {
        this.Cod_Cidade = Cod_Cidade;
    }

    public String getNom_Cidade() {
        return Nom_Cidade;
    }

    public void setNom_Cidade(String Nom_Cidade) {
        this.Nom_Cidade = Nom_Cidade;
    }

}
