package br.cefetmg.implicare.model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author João Victor Bonfim
 */
//WIP
@Entity(name = "CepChave")
@Table(name = "cepchave")
@IdClass(CepJPA.class)
public class CepChave implements Serializable {

    @Id
    @Column(name = "codCEP")
    private long codCEP;

    @Id
    @Column(name = "codCidade")
    private int codCidade;

    @Id
    @Column(name = "codEstado")
    private int codEstado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.codCEP ^ (this.codCEP >>> 32));
        hash = 83 * hash + this.codCidade;
        hash = 83 * hash + this.codEstado;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CepChave other = (CepChave) o;

        return this.codCEP == other.codCEP
                && this.codCidade == other.codCidade
                && this.codEstado == other.codEstado;
    }

    public CepChave(long codCEP, int codCidade, int codEstado) {
        this.codCEP = codCEP;
        this.codCidade = codCidade;
        this.codEstado = codEstado;
    }

    public CepChave() {
    }

    public long getCodCEP() {
        return codCEP;
    }

    public void setCodCEP(long codCEP) {
        this.codCEP = codCEP;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }
}
