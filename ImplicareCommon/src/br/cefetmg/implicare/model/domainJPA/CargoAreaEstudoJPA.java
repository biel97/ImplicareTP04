package br.cefetmg.implicare.model.domainJPA;

/**
 *
 * @author João Victor Bonfim
 * @deprecated Usar as propriedades nativas do JPA ao invés desta classe.
 */
public class CargoAreaEstudoJPA {
    private int Cod_Area_Estudo;
    private int Cod_Cargo;
    
    public CargoAreaEstudoJPA(int Cod_Area_Estudo, int Cod_Cargo){
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Cod_Cargo = Cod_Cargo;
    }

    public int getCod_Area_Estudo()
    {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo)
    {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public int getCod_Cargo()
    {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo)
    {
        this.Cod_Cargo = Cod_Cargo;
    }
    
}
