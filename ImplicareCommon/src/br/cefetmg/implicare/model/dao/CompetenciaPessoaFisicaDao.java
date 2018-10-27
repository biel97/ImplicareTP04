package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CompetenciaPessoaFisica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CompetenciaPessoaFisicaDao {

    public void insert(CompetenciaPessoaFisica CompetenciaPessoaFisica) throws PersistenceException;

    public boolean delete(long CPF, int Cod_Competencia) throws PersistenceException;

    public List<CompetenciaPessoaFisica> getCompetenciasPessoaFisica(long CPF) throws PersistenceException;

    public CompetenciaPessoaFisica getCompetenciaPessoaFisicaCod(long CPF, int Cod_Competencia) throws PersistenceException;
}
