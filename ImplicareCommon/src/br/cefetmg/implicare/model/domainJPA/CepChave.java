package br.cefetmg.implicare.model.domainJPA;

/**
 *
 * @author João Victor Bonfim
 */
public class CepChave implements java.io.Serializable {

    private CidadeJPA cidade;

    private long codCEP;

    public CepChave(CidadeJPA cidade, long codCEP) {
        setCidade(cidade);
        setCodCEP(codCEP);
    }

    public CepChave() {
    }

    public CidadeJPA getCidade() {
        return cidade;
    }

    public void setCidade(CidadeJPA cidade) {
        this.cidade = cidade;
    }

    public long getCodCEP() {
        return codCEP;
    }

    public void setCodCEP(long codCEP) {
        this.codCEP = codCEP;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getCidade(), getCodCEP());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CepChave objeto = (CepChave) o;

        return java.util.Objects.equals(getCidade(), objeto.getCidade())
                && java.util.Objects.equals(getCodCEP(), objeto.getCodCEP());
    }
}
