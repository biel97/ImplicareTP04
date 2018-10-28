package br.cefetmg.implicare.model.domainJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author João Victor Bonfim
 */
@Entity(name = "Cidade")
@Table(name = "cidade")
@IdClass(CidadeChave.class)
public class CidadeJPA implements java.io.Serializable {

    //Preciso que alguém faça a classe EstadoJPA para concluir a implementação.
    @Id
    @Column(name = "estado")
    private int estado;

    @Id
    @Column(name = "codCidade")
    private int codCidade;

    private String nomCidade;

    public CidadeJPA() {
    }

    public CidadeJPA(int estado, int codCidade, String nomCidade) {
        this.estado = estado;
        this.codCidade = codCidade;
        this.nomCidade = nomCidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public String getNomCidade() {
        return nomCidade;
    }

    public void setNomCidade(String nomCidade) {
        this.nomCidade = nomCidade;
    }
}
