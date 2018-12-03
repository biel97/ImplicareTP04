package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Proficiencia;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface ProficienciaDao {

    public List<Proficiencia> listAll() throws PersistenceException, RemoteException;

    public Proficiencia getProficienciaCod(int Cod_Proficiencia) throws PersistenceException, RemoteException;
}
