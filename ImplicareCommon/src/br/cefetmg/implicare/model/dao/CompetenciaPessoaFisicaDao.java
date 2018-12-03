package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CompetenciaPessoaFisica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CompetenciaPessoaFisicaDao extends Remote {

    public void insert(CompetenciaPessoaFisica CompetenciaPessoaFisica) throws PersistenceException, RemoteException;

    public boolean delete(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException;

    public List<CompetenciaPessoaFisica> getCompetenciasPessoaFisica(long CPF) throws PersistenceException, RemoteException;

    public CompetenciaPessoaFisica getCompetenciaPessoaFisicaCod(long CPF, int Cod_Competencia) throws PersistenceException, RemoteException;
}
