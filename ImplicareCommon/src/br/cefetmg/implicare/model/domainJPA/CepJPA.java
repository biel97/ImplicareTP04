package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author João Victor Bonfim
 */
@Entity(name = "CEP")
@Table(name = "cep")
@IdClass(CepChave.class)
public class CepJPA implements java.io.Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codCidade")
    private CidadeJPA cidade;

    @Id
    @Column(name = "codCEP")
    private long codCEP;

    public CepJPA() {
    }

    public CepJPA(CidadeJPA cidade, long codCEP) {
        this.cidade = cidade;
        this.codCEP = codCEP;
    }

    public long getCodCEP() {
        return codCEP;
    }

    public void setCodCEP(long codCEP) {
        this.codCEP = codCEP;
    }

    public CidadeJPA getCidade() {
        return cidade;
    }

    public void setCidade(CidadeJPA cidade) {
        this.cidade = cidade;
    }
}
