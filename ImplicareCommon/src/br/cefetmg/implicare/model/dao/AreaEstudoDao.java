package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public interface AreaEstudoDao extends Remote {

    public ArrayList<AreaEstudo> listAll() throws PersistenceException, RemoteException;

    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException, RemoteException;
}
