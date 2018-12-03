package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.Cidade;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface CidadeDao extends Remote {

    public List<Cidade> getCidades(int Cod_Estado) throws PersistenceException, RemoteException;

    public Cidade getCidadeCod(int Cod_Cidade) throws PersistenceException, RemoteException;
}
