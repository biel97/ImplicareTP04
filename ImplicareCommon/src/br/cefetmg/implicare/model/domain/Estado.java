package br.cefetmg.implicare.model.domain;

/**
 *
 * @author Gabriel
 */
public class Estado {

    private int Cod_Estado;
    private String Nom_Estado;

    public Estado() {
    }

    public Estado(int Cod_Estado, String Nom_Estado) {
        this.Cod_Estado = Cod_Estado;
        this.Nom_Estado = Nom_Estado;
    }

    public int getCod_Estado() {
        return Cod_Estado;
    }

    public void setCod_Estado(int Cod_Estado) {
        this.Cod_Estado = Cod_Estado;
    }

    public String getNom_Estado() {
        return Nom_Estado;
    }

    public void setNom_Estado(String Nom_Estado) {
        this.Nom_Estado = Nom_Estado;
    }

}
