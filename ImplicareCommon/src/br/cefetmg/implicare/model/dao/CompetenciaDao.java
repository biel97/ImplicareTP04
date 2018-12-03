package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Competencia;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CompetenciaDao {

    public List<Competencia> listAll() throws PersistenceException, RemoteException;

    public Competencia getCompetenciaCod(int Cod_Competencia) throws PersistenceException, RemoteException;
}
