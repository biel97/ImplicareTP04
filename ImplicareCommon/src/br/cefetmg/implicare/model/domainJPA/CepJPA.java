package br.cefetmg.implicare.model.domainJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author João Victor Bonfim
 */
//Praticamente concluído.
@Entity(name = "cep")
public class CepJPA implements Serializable {

    @Id
    private CepChave chavePrimaria;

    public CepJPA(){}

    public CepJPA(long codCEP, int codCidade, int codEstado) {
        chavePrimaria = new CepChave(codCEP, codCidade, codEstado);
    }

    public long getCodCEP() {
        return chavePrimaria.getCodCEP();
    }

    public void setCodCEP(long codCEP) {
        chavePrimaria.setCodCEP(codCEP);
    }

    public int getCodCidade() {
        return chavePrimaria.getCodCidade();
    }

    public void setCodCidade(int codCidade) {
        chavePrimaria.setCodCidade(codCidade);
    }

    public int getCodEstado() {
        return chavePrimaria.getCodEstado();
    }

    public void setCodEstado(int codEstado) {
        chavePrimaria.setCodEstado(codEstado);
    }
}
