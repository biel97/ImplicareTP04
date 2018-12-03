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
@Entity(name="AreaEstudo")
public class AreaEstudo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_area_estudo")
    private int Cod_Area_Estudo;
    
    @Column(name = "nom_area_estudo")
    private String Nom_Area_Estudo;
    

    public AreaEstudo() {
    }

    public AreaEstudo(int Cod_Area_Estudo, String Nom_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Nom_Area_Estudo = Nom_Area_Estudo;
    }

    public int getCod_Area_Estudo() {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public String getNom_Area_Estudo() {
        return Nom_Area_Estudo;
    }

    public void setNom_Area_Estudo(String Nom_Area_Estudo) {
        this.Nom_Area_Estudo = Nom_Area_Estudo;
    }

}
