package br.cefetmg.implicare.model.domainJPA;

/**
 *
 * @author João Victor
 */
public class CidadeChave implements java.io.Serializable {
    
    //Preciso que alguém faça a classe EstadoJPA para concluir a implementação.
    private int estado;

    private int codCidade;

    public CidadeChave(int codEstado, int codCidade) {
        this.estado = codEstado;
        this.codCidade = codCidade;
    }

    public CidadeChave() {
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

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getEstado(), getCodCidade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CidadeChave outro = (CidadeChave) o;

        return java.util.Objects.equals(getEstado(), outro.getEstado())
                && java.util.Objects.equals(getCodCidade(), outro.getCodCidade());
    }
}
