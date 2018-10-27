package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Gabriel
 * 
 */

public class AreaEstudoJPA {
    
    @Id
    @Column(name="Cod_Area_Estudo", nullable = false)
    private int Cod_Area_Estudo;
    
    @Column(name="Nom_Area_Estudo", nullable = false)
    private String Nom_Area_Estudo;

    public AreaEstudoJPA() {
    }

    public AreaEstudoJPA(int Cod_Area_Estudo, String Nom_Area_Estudo) {
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
