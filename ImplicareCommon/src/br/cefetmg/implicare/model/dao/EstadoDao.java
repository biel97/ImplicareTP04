package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface EstadoDao extends Remote {

    public List<Estado> listAll() throws PersistenceException, RemoteException;

    public Estado getEstadoCod(int Cod_Estado) throws PersistenceException, RemoteException;
}
