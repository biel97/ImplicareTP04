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
@Entity(name="Cargo")
public class Cargo {

    private int Cod_Cargo;
    private String Nom_Cargo;

    public Cargo() {
    }

    public Cargo(int Cod_Cargo, String Nom_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
        this.Nom_Cargo = Nom_Cargo;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public String getNom_Cargo() {
        return Nom_Cargo;
    }

    public void setNom_Cargo(String Nom_Cargo) {
        this.Nom_Cargo = Nom_Cargo;
    }

}
