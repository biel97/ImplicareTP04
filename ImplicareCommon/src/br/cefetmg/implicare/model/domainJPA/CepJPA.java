package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.IdClass;

/**
 *
 * @author João Victor Bonfim
 */

//WIP

@Entity
public class CepJPA {
    
    @Embedded
    private CepChave chave;
    
    public CepJPA(long Cod_CEP, int Cod_Cidade, int Cod_Estado)
    {
        
    }
    
    public long getCod_CEP()
    {
        
    }

    public void setCod_CEP(long Cod_CEP)
    {
        
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

    public void setCod_Estado(int Cod_Estado)
    {
        
    }
}
