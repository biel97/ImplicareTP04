package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Embeddable;

/**
 *
 * @author João Victor Bonfim
 */

//WIP

@Embeddable
public class CepChave {
    
    private long Cod_CEP;
    private int Cod_Cidade;
    private int Cod_Estado;

    public CepChave(long Cod_CEP, int Cod_Cidade, int Cod_Estado) 
    {
        this.Cod_CEP = Cod_CEP;
        this.Cod_Cidade = Cod_Cidade;
        this.Cod_Estado = Cod_Estado;
    }

    public long getCod_CEP()
    {
        return Cod_CEP;
    }

    public void setCod_CEP(long Cod_CEP)
    {
        this.Cod_CEP = Cod_CEP;
    }

    public int getCod_Cidade() {
        return Cod_Cidade;
    }

    public void setCod_Cidade(int Cod_Cidade) {
        this.Cod_Cidade = Cod_Cidade;
    }

    public int getCod_Estado() {
        return Cod_Estado;
    }

    public void setCod_Estado(int Cod_Estado) {
        this.Cod_Estado = Cod_Estado;
    }
    
    
}