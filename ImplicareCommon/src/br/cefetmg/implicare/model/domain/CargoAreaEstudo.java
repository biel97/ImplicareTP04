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
@Entity(name="CargoAreaEstudo")
public class CargoAreaEstudo {

    private int Cod_Area_Estudo;
    private int Cod_Cargo;

    public CargoAreaEstudo() {
    }

    public CargoAreaEstudo(int Cod_Area_Estudo, int Cod_Cargo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Cod_Cargo = Cod_Cargo;
    }

    public int getCod_Area_Estudo() {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

}
